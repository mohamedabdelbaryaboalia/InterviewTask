package me.mohamedabdelbary.jawabkomtask.Main.Presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import me.mohamedabdelbary.jawabkomtask.Adapters.VehiclesCustomAdapter
import me.mohamedabdelbary.jawabkomtask.ClassModels.Vehicle

import me.mohamedabdelbary.jawabkomtask.Main.MVP_Interfaces.MVP_MAIN
import me.mohamedabdelbary.jawabkomtask.Main.Model.MainModel
import me.mohamedabdelbary.jawabkomtask.R

class MainPresenter(internal var mView: MVP_MAIN.RequiredViewOps) : MVP_MAIN.ProvidedPresenterOps, MVP_MAIN.RequiredPresenterOps {
    override fun notifyAdapter() {

        mView.notifyAdapter()
    }


    internal var mModel: MVP_MAIN.ProvidedModelOps? = null



    fun setModel(model: MainModel) {
        this.mModel = model
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehiclesCustomAdapter.CustomViewHolder {
        val view = LayoutInflater.from(mView.activityContext).inflate(R.layout.vehicle_layout,parent,false)
        return VehiclesCustomAdapter.CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mModel!!.getSize()
    }

    override fun onBindViewHolder(holder: VehiclesCustomAdapter.CustomViewHolder, position: Int) {
        val vehicle : Vehicle = mModel!!.getListItem(position)
        val price = "${vehicle.price}  ${mView.activityContext.getString(R.string.default_currency)}"
        val milage = "${vehicle.mileage}  ${mView.activityContext.getString(R.string.default_distance_unit)}"
        val fuelType = vehicle.fuelType
        val make = vehicle.make
        holder.price.setText(price)
        holder.milage.setText(milage)
        holder.fuelType.setText(fuelType)
        holder.make.setText(make)
        loadVehicleImage(holder.vehicleImage, if(vehicle.images.isNotEmpty()) vehicle.images.get(0) else null )


    }

    private fun loadVehicleImage(vehicleImage: ImageView, url: String?) {

        Picasso.get().load(url).placeholder(R.drawable.no_image).into(vehicleImage)
    }

    override fun getData() {
        mModel!!.getData()
    }

    override val appContext : Context get() = mView.appContext

    override val activityContext: Context get() = mView.activityContext



}

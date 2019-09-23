package me.mohamedabdelbary.jawabkomtask.Adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import me.mohamedabdelbary.jawabkomtask.Main.MVP_Interfaces.MVP_MAIN
import me.mohamedabdelbary.jawabkomtask.R

class VehiclesCustomAdapter(var mPresenter : MVP_MAIN.ProvidedPresenterOps?) : Adapter<VehiclesCustomAdapter.CustomViewHolder>() {



    
    
    
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return  mPresenter!!.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return mPresenter!!.getItemCount()
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        mPresenter!!.onBindViewHolder(holder,position)
    }






    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vehicleImage : ImageView
        val price : TextView
        val milage : TextView
        val make : TextView
        val fuelType : TextView
        init {
            vehicleImage = itemView.findViewById(R.id.imageView)
            price = itemView.findViewById(R.id.price)
            milage = itemView.findViewById(R.id.milage)
            make = itemView.findViewById(R.id.make)
            fuelType = itemView.findViewById(R.id.fuel_type)
        }
    }

}


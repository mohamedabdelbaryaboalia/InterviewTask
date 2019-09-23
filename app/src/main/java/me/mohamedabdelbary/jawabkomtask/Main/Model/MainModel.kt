package me.mohamedabdelbary.jawabkomtask.Main.Model

import android.util.Log
import me.mohamedabdelbary.jawabkomtask.ClassModels.Vehicle
import me.mohamedabdelbary.jawabkomtask.ClassModels.VehicleList
import me.mohamedabdelbary.jawabkomtask.HelperClasses.VehiclesDataRetrieve
import me.mohamedabdelbary.jawabkomtask.Main.MVP_Interfaces.MVP_MAIN
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModel(private val mPresenter: MVP_MAIN.RequiredPresenterOps) : MVP_MAIN.ProvidedModelOps {

    private var list : List <Vehicle>
    private val dataRetrieve: VehiclesDataRetrieve


    init {
        dataRetrieve = VehiclesDataRetrieve()
        list = ArrayList()

    }

    override fun getSize(): Int {
        return list.size
    }

    override fun getListItem(position: Int): Vehicle {
       return list.get(position)
    }


    override fun getData() {
        handleCall(dataRetrieve.getData(mPresenter.activityContext))
    }

    private fun handleCall(data: Call<VehicleList>) {
        data.enqueue(object : Callback<VehicleList> {
            override fun onResponse(call: Call<VehicleList>, response: Response<VehicleList>) {

                val vehicles = response.body()
                list = vehicles!!.list
                mPresenter.notifyAdapter()

            }

            override fun onFailure(call: Call<VehicleList>, t: Throwable) {
                Log.d("D_Error",t.message)

            }
        })
    }


}

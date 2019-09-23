package me.mohamedabdelbary.jawabkomtask.HelperClasses

import android.content.Context

import me.mohamedabdelbary.jawabkomtask.ClassModels.Vehicle
import me.mohamedabdelbary.jawabkomtask.ClassModels.VehicleList
import me.mohamedabdelbary.jawabkomtask.HelperInterfaces.DataRetrieve
import me.mohamedabdelbary.jawabkomtask.Networking.ApiClient
import me.mohamedabdelbary.jawabkomtask.Networking.ApiGetVehiclesInterface
import retrofit2.Call

class VehiclesDataRetrieve : DataRetrieve<VehicleList> {
    override fun getData(ctx: Context): Call<VehicleList> {
        val apiInterface = ApiClient.getClient(ctx).create(ApiGetVehiclesInterface::class.java)
        return apiInterface.vehicles
    }
}

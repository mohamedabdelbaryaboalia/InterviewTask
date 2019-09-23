package me.mohamedabdelbary.jawabkomtask.Networking

import me.mohamedabdelbary.jawabkomtask.ClassModels.Vehicle
import me.mohamedabdelbary.jawabkomtask.ClassModels.VehicleList
import retrofit2.Call
import retrofit2.http.GET

interface ApiGetVehiclesInterface {
    @get:GET("iOS-TechChallange/api/index/make=all.json")
    var vehicles: Call<VehicleList>
}

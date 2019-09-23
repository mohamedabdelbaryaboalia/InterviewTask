package me.mohamedabdelbary.jawabkomtask.ClassModels

import com.google.gson.annotations.SerializedName

data class VehicleList (
        @SerializedName("vehicles")
        val list : List<Vehicle>
)
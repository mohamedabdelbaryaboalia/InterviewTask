package me.mohamedabdelbary.jawabkomtask.ClassModels


import com.google.gson.annotations.SerializedName

data class Vehicle (
    @SerializedName("ID")
     val id: Int ,
    @SerializedName("FirstRegistration")
     val firstRegistration: String,
    @SerializedName("AccidentFree")
     val accidentFree: Boolean ,
    @SerializedName("Images")
     val images: List<String>,
    @SerializedName("PowerKW")
     val powerKW: Int ,
    @SerializedName("Address")
     val address: String,
    @SerializedName("Price")
     val price: Int ,
    @SerializedName("Mileage")
     val mileage: Int ,
    @SerializedName("Make")
     val make: String,
    @SerializedName("FuelType")
     val fuelType: String
)

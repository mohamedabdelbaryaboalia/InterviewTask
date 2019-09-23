package me.mohamedabdelbary.jawabkomtask.HelperInterfaces

import android.content.Context
import me.mohamedabdelbary.jawabkomtask.ClassModels.Vehicle
import retrofit2.Call

interface DataRetrieve<T> {
    fun getData(ctx: Context): Call<T>
}

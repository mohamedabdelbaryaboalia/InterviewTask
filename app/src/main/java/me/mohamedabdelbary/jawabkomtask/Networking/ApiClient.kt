package me.mohamedabdelbary.jawabkomtask.Networking

import android.content.Context

import java.io.IOException

import me.mohamedabdelbary.jawabkomtask.R
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var retrofit: Retrofit? = null

    fun getClient(ctx: Context): Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor { chain ->
            var request = chain.request()
            val url = request.url().newBuilder().build()
            request = request.newBuilder().url(url).build()
            chain.proceed(request)
        }.build()


        retrofit = Retrofit.Builder()
                .baseUrl(ctx.getString(R.string.base_api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()


        return retrofit as Retrofit


    }

}

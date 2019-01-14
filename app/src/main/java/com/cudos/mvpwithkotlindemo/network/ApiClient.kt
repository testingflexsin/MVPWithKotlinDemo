package com.cudos.mvpwithkotlindemo.network

import com.cudos.mvpwithkotlindemo.utils.Constants

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    /*
    We need to create the Retrofit instance to send the network requests.
    we need to use the Retrofit Builder class and specify the base URL for the service
    */

    internal var client = OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor(Constants.USER, Constants.PASS))
            .build()

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return this!!.retrofit!!
    }
}

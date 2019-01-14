package com.cudos.mvpwithkotlindemo.network


import com.cudos.mvpwithkotlindemo.models.home_model.HomeListResponse
import com.cudos.mvpwithkotlindemo.models.home_model.login.LoginResponse

import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    /*
    For our request method getUserList() the JSONResponse object is wrapped in Call object. By using Call,
    the request is made Asynchronous so you need not worry about UI blocking or AsyncTask.
    The JSON response received after making the request it is stored in JSONResponse object.
    * */

    @FormUrlEncoded
    @Headers("USER-ID: 233", "Accept-Language: english", "OAUTH-TOKEN: MjMz_df3a8195d5606d0380ed03ef8aafb6b8", "X-API-KEY: VEIp4AWImE", "Authorization: Basic dmlwZ3JvdXA6MTIzNDU2")
    @POST("users/getUserList")
    fun getUserList(@FieldMap prma: Map<String, String>
    ): Call<HomeListResponse>

    @FormUrlEncoded
    @Headers("USER-ID: 619", "Accept-Language: english", "OAUTH-TOKEN: MjA=_61e749a9669d92fe7026e255c478629c", "X-API-KEY: VEIp4AWImE", "Authorization: Basic dmlwZ3JvdXA6MTIzNDU2")
    @POST("users/login")
    fun getUserLogin(@FieldMap prma: Map<String, String>
    ): Call<LoginResponse>
}

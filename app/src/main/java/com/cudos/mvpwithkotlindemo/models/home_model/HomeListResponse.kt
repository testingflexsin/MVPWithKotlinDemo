package com.cudos.mvpwithkotlindemo.models.home_model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HomeListResponse {

    /*
    HomeListResponse is pojo class which have user to get response data with Retrofit.
    In this application with a good layered architecture, this model would only be the gateway to
    the domain layer or business logic. See it as the provider of the data we want to display
     in the view. Model’s responsibilities include using APIs, caching data, managing databases.
    */

    @SerializedName("status")
    @Expose
    var status: Int? = null
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null
    @SerializedName("payment_status")
    @Expose
    var paymentStatus: PaymentStatus? = null
    @SerializedName("TotalRecordCount")
    @Expose
    var totalRecordCount: Int? = null

}

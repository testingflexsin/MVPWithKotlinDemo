package com.cudos.mvpwithkotlindemo.models.home_model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SubscriptionPlan {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("end_date")
    @Expose
    var endDate: String? = null

}

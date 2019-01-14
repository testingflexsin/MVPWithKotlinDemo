package com.cudos.mvpwithkotlindemo.models.home_model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PaymentStatus {

    @SerializedName("subscription_plan")
    @Expose
    var subscriptionPlan: SubscriptionPlan? = null
    @SerializedName("vip_subscription_plan")
    @Expose
    var vipSubscriptionPlan: VipSubscriptionPlan? = null

}

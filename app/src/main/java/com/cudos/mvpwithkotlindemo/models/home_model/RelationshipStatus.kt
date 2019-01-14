package com.cudos.mvpwithkotlindemo.models.home_model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RelationshipStatus {

    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("req-id")
    @Expose
    var reqId: String? = null

}

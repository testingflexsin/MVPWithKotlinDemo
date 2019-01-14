package com.cudos.mvpwithkotlindemo.models.home_model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum {

    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
    @SerializedName("alias_name")
    @Expose
    var aliasName: String? = null
    @SerializedName("is_online")
    @Expose
    var isOnline: String? = null
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("created_date")
    @Expose
    var createdDate: String? = null
    @SerializedName("group_id")
    @Expose
    var groupId: String? = null
    @SerializedName("gender_id")
    @Expose
    var genderId: String? = null
    @SerializedName("distance")
    @Expose
    var distance: String? = null
    @SerializedName("photo_count")
    @Expose
    var photoCount: String? = null
    @SerializedName("about_me")
    @Expose
    var aboutMe: String? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("state")
    @Expose
    var state: String? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("country_spe")
    @Expose
    var countrySpe: String? = null
    @SerializedName("state_spe")
    @Expose
    var stateSpe: String? = null
    @SerializedName("city_spe")
    @Expose
    var citySpe: String? = null
    @SerializedName("birthdate")
    @Expose
    var birthdate: String? = null
    @SerializedName("age_old")
    @Expose
    var ageOld: String? = null
    @SerializedName("children_count")
    @Expose
    var childrenCount: String? = null
    @SerializedName("is_verified")
    @Expose
    var isVerified: String? = null
    @SerializedName("is_vip")
    @Expose
    var isVip: String? = null
    @SerializedName("latitude")
    @Expose
    var latitude: String? = null
    @SerializedName("longitude")
    @Expose
    var longitude: String? = null
    @SerializedName("join_date_status")
    @Expose
    var joinDateStatus: String? = null
    @SerializedName("height_feet")
    @Expose
    var heightFeet: String? = null
    @SerializedName("user_image")
    @Expose
    var userImage: String? = null
    @SerializedName("age")
    @Expose
    var age: String? = null
    @SerializedName("time_period")
    @Expose
    var timePeriod: String? = null
    @SerializedName("relationship_status")
    @Expose
    var relationshipStatus: RelationshipStatus? = null

}

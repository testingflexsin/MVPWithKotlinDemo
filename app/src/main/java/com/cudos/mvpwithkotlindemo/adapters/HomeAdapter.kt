package com.cudos.mvpwithkotlindemo.adapters

import android.app.Activity
import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.cudos.mvpwithkotlindemo.R
import com.cudos.mvpwithkotlindemo.models.home_model.Datum
import com.cudos.mvpwithkotlindemo.view.activity.HomeActivity
import com.cudos.mvpwithkotlindemo.view.custom_views.CustomTextView
import com.cudos.mvpwithkotlindemo.view.custom_views.RoundRectCornerImageView

import java.net.URLDecoder

/**
HomeAdapter a bridge between the UI HomeActivity and the data source that fill data into the UI Component
 */
class HomeAdapter(private val usersList: List<Datum>, context: Activity, userCallbacks: UserClickCallback) : RecyclerView.Adapter<HomeAdapter.HomeView>() {
    private val context: Context
    private var userCallbacks: UserClickCallback? = null

    init {
        this.context = context
        this.userCallbacks = userCallbacks
    }

    /*
    Inflate layout  and return HomeView class object
    * */
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HomeView {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.home_items, viewGroup, false)
        return HomeView(view)
    }


    /*
       Bind view with HomeView
       * */
    override fun onBindViewHolder(holder: HomeView, position: Int) {
        holder.name.text = usersList[position].fullName
        Glide.with(context).load(usersList[position].userImage).into(holder.image)

        holder.aboutMe.text = URLDecoder.decode(usersList[position].aboutMe)
        var distanceStr = usersList[position].distance
        if (distanceStr == null || distanceStr.trim { it <= ' ' }.length == 0 || distanceStr.equals("null", ignoreCase = true))
            distanceStr = "0"
        else
            distanceStr = usersList[position].distance
        if (usersList[position].distance == "1" || usersList[position].distance == "0") {
            holder.distance.text = distanceStr + " " + context.getString(R.string.mile_away)
        } else {
            holder.distance.text = distanceStr + " " + context.getString(R.string.miles_away)
        }
        holder.noOfPhotos.text = usersList[position].photoCount
        var ageStr: String? = ""
        var cityStr: String? = ""
        var stateStr: String? = ""
        var countryStr: String? = ""
        ageStr = usersList[position].age
        cityStr = usersList[position].city
        stateStr = usersList[position].state
        countryStr = usersList[position].country
        if (ageStr == null || ageStr.trim { it <= ' ' }.length == 0 || ageStr.equals("null", ignoreCase = true) || ageStr.equals("0", ignoreCase = true)) {
            if (cityStr == null || cityStr.trim { it <= ' ' }.length == 0 || cityStr.equals("null", ignoreCase = true) || cityStr == "0") {
                holder.ageLocation.text = ""
            } else {
                if (cityStr != "") {
                    holder.ageLocation.text = cityStr
                } else if (stateStr != "") {
                    holder.ageLocation.text = stateStr
                } else {
                    holder.ageLocation.text = countryStr
                }
            }
        } else {
            if (cityStr == null || cityStr.trim { it <= ' ' }.length == 0 || cityStr.equals("null", ignoreCase = true) || cityStr.equals("0", ignoreCase = true)) {
                //                holder.ageLocation.setText(ageStr);
                if (cityStr != "") {
                    holder.ageLocation.text = "$ageStr/$cityStr"
                } else if (stateStr != "") {
                    holder.ageLocation.text = "$ageStr/$stateStr"
                } else {
                    holder.ageLocation.text = "$ageStr/$countryStr"
                }
            } else {
                if (cityStr != "") {
                    holder.ageLocation.text = "$ageStr/$cityStr"
                } else if (stateStr != "") {
                    holder.ageLocation.text = "$ageStr/$stateStr"
                } else {
                    holder.ageLocation.text = "$ageStr/$countryStr"
                }
            }
        }
        clickListener(holder, position, usersList)
    }

    /*
   Call onUserClick method and set user position with its all data
   * */
    private fun clickListener(holder: HomeView, position: Int, usersList: List<Datum>) {
        holder.cardView.setOnClickListener {
            userCallbacks?.onUserClick(position, usersList)
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    /*
   Crerate custom RecyclerView.ViewHolder
* */
    class HomeView(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardView: CardView
        val name: CustomTextView
        val ageLocation: CustomTextView
        val distance: CustomTextView
        val aboutMe: CustomTextView
        val noOfPhotos: CustomTextView
        val unReadMessageCount: CustomTextView
        val onlineStatus: ImageView
        val image: RoundRectCornerImageView


        /*
        Initialize layout views.
        */
        init {
            cardView = itemView.findViewById(R.id.cardView)
            name = itemView.findViewById(R.id.userName)
            ageLocation = itemView.findViewById(R.id.ageLocation)
            image = itemView.findViewById(R.id.userImage)
            onlineStatus = itemView.findViewById(R.id.onlineStatus)
            distance = itemView.findViewById(R.id.distance)
            aboutMe = itemView.findViewById(R.id.aboutMe)
            noOfPhotos = itemView.findViewById(R.id.noOfPhotos)
            unReadMessageCount = itemView.findViewById(R.id.unReadMessageCount)

        }


    }

    /*
     Custom Interface to perform Event on list item of home activity
    * */
    interface UserClickCallback {
        /*
        Callback method for item click
        */
        fun onUserClick(position: Int, usersList: List<Datum>)
    }
}

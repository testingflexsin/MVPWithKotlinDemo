package com.cudos.mvpwithkotlindemo.presenter_impl


import android.content.Context

import com.cudos.mvpwithkotlindemo.R
import com.cudos.mvpwithkotlindemo.models.home_model.HomeListResponse
import com.cudos.mvpwithkotlindemo.network.ApiClient
import com.cudos.mvpwithkotlindemo.network.ApiInterface
import com.cudos.mvpwithkotlindemo.presenter.HomePresenter
import com.cudos.mvpwithkotlindemo.view.HomeView

import java.util.HashMap

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
  The Presenter is responsible to act as the middle man between View and Model.
  It retrieves data from the Model and returns it formatted to the View.

  */
class HomePresenterImpl(private val homeView: HomeView, private val context: Context) : HomePresenter {

    private val homePresenter: HomePresenter? = null


    /*
    To carry out a asyncronous request Call object should be created from RequestInterface object
    by calling getUserList() method.
    * */

    //Method getUserList() implementation to get respnse from service.
    override fun getUserList(flag: Boolean?) {
        if (flag!!) {
            //show Progressbar method call
            homeView.showProgress()
        }
        val apiInterface = ApiClient.getClient().create(ApiInterface::class.java)

        val body = HashMap<String, String>()
        body["latitude"] = "28.6185753"
        body["longitude"] = "77.3906657"
        body["user_id"] = "233"
        body["type"] = "2"
        body["limit"] = "20"
        body["offset"] = "0"


        val call = apiInterface.getUserList(body)
        call.enqueue(object : Callback<HomeListResponse> {
            override fun onResponse(call: Call<HomeListResponse>, response: Response<HomeListResponse>?) {
                //Hide Progressbar method call
                homeView.hideProgress()
                if (response != null && response.body().data != null) {
                    //Set response data method call
                    homeView.getData(response)
                } else {
                    //Show erroe message method call
                    homeView.showToast(context.getString(R.string.something_worng))
                }
            }

            override fun onFailure(call: Call<HomeListResponse>, t: Throwable) {
                //Hide Progressbar method call
                homeView.hideProgress()
                //Show error message method call
                homeView.showToast(context.getString(R.string.something_worng))
            }
        })

    }

}
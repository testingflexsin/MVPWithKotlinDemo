package com.cudos.mvpwithkotlindemo.presenter_impl

import android.content.Context

import com.cudos.mvpwithkotlindemo.R
import com.cudos.mvpwithkotlindemo.models.home_model.login.LoginResponse
import com.cudos.mvpwithkotlindemo.network.ApiClient
import com.cudos.mvpwithkotlindemo.network.ApiInterface
import com.cudos.mvpwithkotlindemo.presenter.HomePresenter
import com.cudos.mvpwithkotlindemo.presenter.LoginPresenter
import com.cudos.mvpwithkotlindemo.view.LoginView

import java.util.HashMap

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
  The Presenter is responsible to act as the middle man between View and Model.
  It retrieves data from the Model and returns it formatted to the View.

  */
class LoginPresenterImpl(private val loginView: LoginView, private val context: Context) : LoginPresenter {
    private val homePresenter: HomePresenter? = null

    /*
 To carry out a asyncronous request Call object should be created from RequestInterface object
 by calling getLogin() method.
 * */


    //Method getLogin() implementation to get respnse from service.
    override fun getLogin(flag: Boolean?, email: String, pass: String) {
        if (flag!!) {
            //show Progressbar method call
            loginView.showProgress()
        }

        if (email == "" && pass == "") {
            //Show error message method call
            loginView.showToast(context.getString(R.string.email_pass))
            return
        }

        val apiInterface = ApiClient.getClient().create<ApiInterface>(ApiInterface::class.java!!)

        val body = HashMap<String, String>()
        body["email"] = email
        body["password"] = pass
        body["latitude"] = "28.6185753"
        body["longitude"] = "77.3906657"
        body["device_token"] = ""
        body["device_type_id"] = "1"
        body["lang_id"] = "1"

        val call = apiInterface.getUserLogin(body)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>?) {
                //Hide Progressbar method call
                loginView.hideProgress()
                if (response != null && response.body() != null) {
                    if (response.body().status == "1") {
                        //Set response data method call
                        loginView.getData(response)
                    } else if (response.body().status == "0") {
                        //Show error message method call
                        loginView.showToast(response.body().message!!)
                    }
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                //Hide Progressbar method call
                loginView.hideProgress()
                //Show error message method call
                loginView.showToast(context.getString(R.string.something_worng))
            }
        })
    }
}
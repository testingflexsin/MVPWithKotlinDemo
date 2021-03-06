package com.cudos.mvpwithkotlindemo.view

import com.cudos.mvpwithkotlindemo.models.home_model.HomeListResponse
import com.cudos.mvpwithkotlindemo.models.home_model.login.LoginResponse

import retrofit2.Response

/*
The View, usually implemented by an Activity, will contain a reference to the presenter.
The only thing that the view will do is to call a method from the Presenter every time
there is an interface action
* */

interface LoginView {


    //Method Declaration for show Progressbar
    fun showProgress()

    //Method Declaration for show message
    fun showToast(msg: String)

    //Method Declaration for hide Progressbar
    fun hideProgress()

    //Method Declaration for get response
    fun getData(s: Response<LoginResponse>)


}

package com.cudos.mvpwithkotlindemo.presenter


/*
  The LoginPresenter is responsible to act as the middle man between View and Model.
  It retrieves data from the Model and returns it formatted to the View.

  Here, LoginPresenter.kotlin works as a middle man between view and model.
  It listen the user action, updates the data model and view
  */


interface LoginPresenter {

    fun getLogin(flag: Boolean?, s: String, toString: String)

}

package com.cudos.mvpwithkotlindemo.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar

import com.cudos.mvpwithkotlindemo.R
import com.cudos.mvpwithkotlindemo.models.home_model.login.LoginResponse
import com.cudos.mvpwithkotlindemo.presenter.LoginPresenter
import com.cudos.mvpwithkotlindemo.presenter_impl.LoginPresenterImpl
import com.cudos.mvpwithkotlindemo.utils.ToastMessage
import com.cudos.mvpwithkotlindemo.view.LoginView
import com.cudos.mvpwithkotlindemo.view.custom_views.CustomButton
import com.cudos.mvpwithkotlindemo.view.custom_views.CustomEditText

import retrofit2.Response

/*
Firstly, This activity implements the LoginPresenter LoginView Interface through which it’s overridden
method will be called. Secondly, we have to create the LoginPresenter object with view as a
constructor. We use this presenter object to listen the user input and update the data as well as view
* */

class LoginActivity : BaseActivity(), LoginView {

    private var signin: CustomButton? = null
    private var email: CustomEditText? = null
    private var pass: CustomEditText? = null
    private var homePresenter: LoginPresenter? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Create LoginPresenterImpl instance and hold in LoginPresenter to call getLogin() method
        homePresenter = LoginPresenterImpl(this, this)

        initView()
        setListeners()

    }

    private fun setListeners() {
        signin!!.setOnClickListener(View.OnClickListener {

            //Check internet connectity
            if (!networkStatus.isOnline(this@LoginActivity)) {
                ToastMessage.get().toastMessageShort(this@LoginActivity,
                        getString(R.string.no_internet))
                return@OnClickListener
            }

            //                homePresenter.getLogin(true,email.getText().toString(), pass.getText().toString());
            homePresenter!!.getLogin(true, "vip5@yopmail.com", "Admin123")
            signin?.isClickable = false
        })
    }

    // Initialize all view of HomeActivity
    private fun initView() {
        signin = findViewById(R.id.login)
        email = findViewById(R.id.email)
        pass = findViewById(R.id.password)
        progressBar = findViewById(R.id.progress_circular)
    }

    //Show Progressbar before get response from service.
    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun showToast(msg: String) {
        signin?.isClickable = true
        progressBar!!.visibility = View.GONE
        ToastMessage.get().toastMessageShort(this, msg)
    }

    //Hide Progressbar after get response from service.
    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
    }

    //getData method of HomeView interface for get webservice response.
    override fun getData(s: Response<LoginResponse>) {
        signin?.isClickable = true

        //        showMSG("Success");
        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))

    }

}

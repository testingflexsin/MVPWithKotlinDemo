package com.cudos.mvpwithkotlindemo.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.cudos.mvpwithkotlindemo.utils.NetworkStatus

/*
If you need some functionality common a bunch of activities in your app,
it’s tempting to create a base Activity class for all of them to subclass
in order to inherit that functionality without having to duplicate it.
Specifically, if you want to do something in a particular lifecycle phase
(such as create, start, resume, etc), it’s tempting to put that in a base class,
 since all inherited classes will execute that automatically.
* */

open class BaseActivity : AppCompatActivity() {
    lateinit var networkStatus: NetworkStatus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkStatus = NetworkStatus()
    }
}

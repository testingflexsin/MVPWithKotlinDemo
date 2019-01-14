package com.cudos.mvpwithkotlindemo.utils

import android.app.Activity
import android.widget.Toast

import com.cudos.mvpwithkotlindemo.view.activity.LoginActivity

class ToastMessage {

    fun toastMessageShort(activity: Activity?, msg: String) {
        if (activity != null)
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

    fun toastMessageLong(activity: Activity?, msg: String) {
        if (activity != null)
            Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    }

    companion object {
        private val toast = ToastMessage()

        fun get(): ToastMessage {
            return toast
        }
    }
}

package com.codestomp

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

/**
 * Created by Burhanuddin Rashid on 1/23/2018.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        photoApp = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    val context: Context
        get() = photoApp!!.context

    companion object {
        var photoApp: App? = null
            private set
        private val TAG = App::class.java.simpleName
    }
}
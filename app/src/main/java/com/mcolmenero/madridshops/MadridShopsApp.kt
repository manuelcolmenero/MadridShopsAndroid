package com.mcolmenero.madridshops

import android.support.multidex.MultiDexApplication
import android.util.Log

class MadridShopsApp: MultiDexApplication() {

    /*
    Se ejecuta cuando se lanza la aplicación
    */
    override fun onCreate() {
        super.onCreate()

        // Init code application wide

        Log.d("App", "onCreate")
    }

    /*

    */
    override fun onLowMemory() {
        super.onLowMemory()


    }



}
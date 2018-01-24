package com.mcolmenero.madridshops

import android.support.multidex.MultiDexApplication
import android.util.Log
import com.mcolmenero.madridshops.domain.interactor.ErrorCompletion
import com.mcolmenero.madridshops.domain.interactor.getallshops.GetAllShopsInteractorFakeImpl
import com.mcolmenero.madridshops.domain.interactor.SuccessCompletion
import com.mcolmenero.madridshops.domain.model.Shops

class MadridShopsApp : MultiDexApplication() {

    /*
    Se ejecuta cuando se lanza la aplicación
    */
    override fun onCreate() {
        super.onCreate()

        // Init code application wide

        Log.d("App", "onCreate")

        val allShopsInteractor = GetAllShopsInteractorFakeImpl()

        allShopsInteractor.execute(object : SuccessCompletion<Shops> {
            override fun successCompletion(element: Shops) {
                Log.d("Shops", "Count: " + element.count())
            }
        }, object : ErrorCompletion {
            override fun errorCompletion(errorMessage: String) {
            }
        })

        allShopsInteractor.execute(success = { shops: Shops ->

        }, error = { msg: String ->

        })

        allShopsInteractor.execute(
                success = object : SuccessCompletion<Shops> {
                    override fun successCompletion(element: Shops) {
                        Log.d("Shops", "Count: " + element.count())
                    }

                },
                error = object : ErrorCompletion {
                    override fun errorCompletion(errorMessage: String) {

                    }

                })
    }

    /*

    */
    override fun onLowMemory() {
        super.onLowMemory()


    }


}
package com.mcolmenero.madridshops.activity

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.mcolmenero.madridshops.R
import com.mcolmenero.madridshops.domain.interactor.internetstatus.InternetStatusInteractorImpl
import com.mcolmenero.madridshops.router.Router
import com.mcolmenero.madridshops.utis.getAlertButtonText
import com.mcolmenero.madridshops.utis.getButtonText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disableButtons()
        checkInternetStatus()
    }

    private fun checkInternetStatus() {
        InternetStatusInteractorImpl().execute(this, success = {

            enableButtons()
            setupButtons()

        }, error = {
            AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(it)
                    .setPositiveButton(getAlertButtonText("setPositiveButton"), { dialog, which ->
                        dialog.dismiss()
                        checkInternetStatus()
                    })
                    .setNegativeButton(getAlertButtonText("setNegativeButton"), { dialog, which ->
                        finish()
                    })
                    .show()
        })
    }

    private fun disableButtons() {
        shop_button.visibility = View.INVISIBLE
        activities_button.visibility = View.INVISIBLE
    }

    private fun enableButtons() {
        shop_button.visibility = View.VISIBLE
        activities_button.visibility = View.VISIBLE
    }

    private fun setupButtons() {
        shop_button.text = getButtonText("Shop")
        activities_button.text = getButtonText("Activity")

        shop_button.setOnClickListener { Router().navigateFromMainActivityToShopActivity(this) }
        //activities_button.setOnClickListener { Router().navigateFromMainActivityToActivitiesActivity(this) }
    }
}

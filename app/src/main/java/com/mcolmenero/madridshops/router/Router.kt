package com.mcolmenero.madridshops.router

import android.content.Intent
import com.mcolmenero.madridshops.activity.MainActivity
import com.mcolmenero.madridshops.activity.PicassoActivity

class Router {

    fun navigateFromMainActivityToPicassoActivity (main: MainActivity){

        main.startActivity(Intent(main, PicassoActivity::class.java))

    }
}



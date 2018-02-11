package com.mcolmenero.madridshops.router

import android.content.Intent
import com.mcolmenero.madridshops.utis.INTENT_SHOP_DETAIL
import com.mcolmenero.madridshops.activity.MainActivity
import com.mcolmenero.madridshops.activity.ShopActivity
import com.mcolmenero.madridshops.activity.ShopDetailActivity
import com.mcolmenero.madridshops.domain.model.Shop

class Router {

    fun navigateFromShopActivityToShopDetailActivity(currentActivity: ShopActivity, shop: Shop) {
        val intent = Intent(currentActivity, ShopDetailActivity::class.java)
        intent.putExtra(INTENT_SHOP_DETAIL, shop)

        currentActivity.startActivity(intent)
    }

    fun navigateFromMainActivityToShopActivity(currentActivity: MainActivity) {
        val intent = Intent(currentActivity, ShopActivity::class.java)

        currentActivity.startActivity(intent)
    }

    /*
    fun navigateFromMainActivityToActivitiesActivity(currentActivity: MainActivity) {
        val intent = Intent(currentActivity, ActivitiesActivity::class.java)

        currentActivity.startActivity(intent)
    }*/

}



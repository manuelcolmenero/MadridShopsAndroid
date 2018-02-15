package com.mcolmenero.madridshops.router

import android.content.Intent
import com.mcolmenero.madridshops.activity.*
import com.mcolmenero.madridshops.domain.model.Activity
import com.mcolmenero.madridshops.domain.model.Shop
import com.mcolmenero.madridshops.utis.INTENT_ACTIVITY_DETAIL
import com.mcolmenero.madridshops.utis.INTENT_SHOP_DETAIL

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


    fun navigateFromActivityActivityToActivityDetailActivity(currentActivity: ActivityActivity, activity: Activity) {
        val intent = Intent(currentActivity, ActivityDetailActivity::class.java)
        intent.putExtra(INTENT_ACTIVITY_DETAIL, activity)

        currentActivity.startActivity(intent)
    }

    fun navigateFromMainActivityToActivityActivity(currentActivity: MainActivity) {
        val intent = Intent(currentActivity, ActivityActivity::class.java)

        currentActivity.startActivity(intent)
    }

}



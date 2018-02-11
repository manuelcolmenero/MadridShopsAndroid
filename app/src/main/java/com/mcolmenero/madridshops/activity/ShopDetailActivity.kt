package com.mcolmenero.madridshops.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mcolmenero.madridshops.R
import com.mcolmenero.madridshops.domain.model.Shop
import com.mcolmenero.madridshops.utis.GOOGLE_MAP_URL
import com.mcolmenero.madridshops.utis.INTENT_SHOP_DETAIL
import com.mcolmenero.madridshops.utis.getShopText
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_shop_detail.*

class ShopDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_detail)

        val shop = intent.getSerializableExtra(INTENT_SHOP_DETAIL) as Shop

        shop_name.text =  shop.name
        shop_description.text = getShopText(shop, "description")
        shop_address.text = shop.address
        shop_hours.text = getShopText(shop,"openingHours")

        Picasso
                .with(this)
                .load(shop.imageURL)
                .placeholder(android.R.drawable.ic_delete)
                .into(shop_image)

        val googleMapUrl = GOOGLE_MAP_URL + shop.latitude + "," + shop.longitude

        Picasso
                .with(this)
                .load(googleMapUrl)
                .placeholder(android.R.drawable.ic_delete)
                .into(shop_google_map)
    }
}
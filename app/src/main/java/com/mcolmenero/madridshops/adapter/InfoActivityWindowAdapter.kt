package com.mcolmenero.madridshops.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.mcolmenero.madridshops.R
import com.mcolmenero.madridshops.domain.model.Activity
import com.mcolmenero.madridshops.utis.getActivityText
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.info_window_adapter.view.*

class InfoActivityWindowAdapter(val context: Context) : GoogleMap.InfoWindowAdapter {

    @SuppressLint("InflateParams")
    override fun getInfoContents(m: Marker): View {
        val view = LayoutInflater.from(context).inflate(R.layout.info_window_adapter, null)

        if (m.tag is Activity) {
            val activity = m.tag as Activity

            view.info_window_name.text = activity.name
            view.info_window_hours.text = getActivityText(activity, "openingHours")
            val activityImage = view.info_window_image

            Picasso
                    .with(context)
                    .load(activity.logoURL)
                    .placeholder(android.R.drawable.ic_delete)
                    .into(activityImage, MarkerActivityCallback(m, activity.logoURL, activityImage, context))
        }

        return view
    }

    override fun getInfoWindow(m: Marker): View? {
        return null
    }
}

class MarkerActivityCallback(val marker: Marker,
                     val url: String,
                     val imageView: ImageView,
                     val context: Context): Callback {

    override fun onSuccess() {
        if (marker.isInfoWindowShown) {
            marker.hideInfoWindow()

            Picasso
                    .with(context)
                    .load(url)
                    .placeholder(android.R.drawable.ic_delete)
                    .into(imageView)

            marker.showInfoWindow()
        }
    }

    override fun onError() { Log.d("PICASSO", "💩 Error updating pinView image on googleMap.") }
}

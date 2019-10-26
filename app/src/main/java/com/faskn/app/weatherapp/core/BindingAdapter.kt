package com.faskn.app.weatherapp.core

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.faskn.app.weatherapp.utils.extensions.hide
import com.faskn.app.weatherapp.utils.extensions.show
import com.squareup.picasso.Picasso

/**
 * Created by Furkan on 2019-10-16
 */

@BindingAdapter("app:visibility")
fun setVisibilty(view: View, isVisible: Boolean) {
    view.hide()
    if (isVisible) {
        view.show()
    } else {
        view.hide()
    }
}

@BindingAdapter("app:setWeatherIcon")
fun setWeatherIcon(view: ImageView, iconPath: String?) {
    if (iconPath.isNullOrEmpty())
        return
    Picasso.get().cancelRequest(view)
    Picasso.get().load("${Constants.NetworkService.BASE_IMAGE_URL}$iconPath@2x.png").into(view)
}

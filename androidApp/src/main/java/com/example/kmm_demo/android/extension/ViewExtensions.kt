package com.example.kmm_demo.android.extension

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.load(url: String, @DrawableRes placeholderResId: Int = 0) =
    Glide.with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .circleCrop()
        .transition(
            DrawableTransitionOptions.withCrossFade(
                DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
            )
        )
        .apply {
            if (placeholderResId != 0) {
                placeholder(placeholderResId)
            }
        }
        .into(this)
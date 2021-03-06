package com.butajlo.koinandroidapp.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun bindImage(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl ?: return)
        .fit()
        .into(view)
}
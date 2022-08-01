package com.example.bottomnavactivity.ext

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: Uri?){
   Glide.with(this).load(url).into(this)
}
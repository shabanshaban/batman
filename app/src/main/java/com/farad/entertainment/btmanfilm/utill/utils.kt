package com.farad.entertainment.btmanfilm.utill

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import coil.load
import coil.request.CachePolicy




fun AppCompatImageView.loadImage(any: Any){
    load(any){
        crossfade(500)
        crossfade(true)
        diskCachePolicy(CachePolicy.ENABLED)
    }

}
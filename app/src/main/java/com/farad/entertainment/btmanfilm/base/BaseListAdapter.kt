package com.farad.entertainment.btmanfilm.base

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.farad.entertainment.btmanfilm.utill.getScreenWidth


abstract class BaseListAdapter<T, VH : RecyclerView.ViewHolder?>(diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(diffUtil) {

    override fun submitList(list: List<T>?) {
        super.submitList(list?.let { ArrayList(it) })
    }


    fun numViewsToShowOnScreen(
        context: Context,
        holder: View,
        sizeItem: Float,
        marginLeftInt: Int = 0,
        marginRight: Int = 0,
        marginBottom: Int = 0,
        marginTop: Int = 0,
    ) {

        val width = (context.getScreenWidth() / sizeItem).toInt()
        val param = LinearLayout.LayoutParams( /*width*/
            width,  /*height*/
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        param.setMargins(marginLeftInt, marginTop, marginRight, marginBottom)
        holder.layoutParams = param
    }
}



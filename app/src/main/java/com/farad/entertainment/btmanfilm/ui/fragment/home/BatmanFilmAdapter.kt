package com.farad.entertainment.btmanfilm.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.farad.entertainment.btmanfilm.base.BaseListAdapter
import com.farad.entertainment.btmanfilm.base.BaseViewHolder
import com.farad.entertainment.btmanfilm.data.model.BatmanSearch
import com.farad.entertainment.btmanfilm.databinding.ItemBtmanFilmBinding
import com.farad.entertainment.btmanfilm.utill.loadImage

class BatmanFilmAdapter : BaseListAdapter<BatmanSearch, BatmanFilmAdapter.Vh>(DIFF_UTIL) {


    private var setOnItemClickListener: ((BatmanSearch) -> Unit)? = null
    fun setOnItemClickListener(listener: (BatmanSearch) -> Unit) {
        setOnItemClickListener = listener
    }

    inner class Vh(private val binding: ItemBtmanFilmBinding) :
        BaseViewHolder<BatmanSearch>(binding.root) {
        override fun bind(obj: BatmanSearch) {

            numViewsToShowOnScreen(binding.layoutItem.context, binding.layoutItem, 3f, 8, 8, 0, 0)
            binding.imageFilm.loadImage(obj.poster)
            binding.tvTitle.text = obj.title
            binding.tvYear.text = obj.year
            binding.layoutItem.setOnClickListener {
                setOnItemClickListener?.invoke(obj)
            }


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemBtmanFilmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.bind(getItem(position))
    }

    private companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<BatmanSearch>() {
            override fun areItemsTheSame(
                oldItem: BatmanSearch,
                newItem: BatmanSearch
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: BatmanSearch,
                newItem: BatmanSearch
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}


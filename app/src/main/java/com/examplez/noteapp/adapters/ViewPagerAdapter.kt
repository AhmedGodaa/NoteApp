package com.examplez.noteapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examplez.noteapp.R
import com.examplez.noteapp.databinding.ItemViewPagerWelcomeBinding

class ViewPagerAdapter(
        val images: List<Int>

) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {4
        val binding = ItemViewPagerWelcomeBinding.inflate(LayoutInflater.from(parent.context)
                , parent
                , false)
        return ViewPagerViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val curImage = images[position]


    }

    override fun getItemCount(): Int {
        return images.size


    }

}

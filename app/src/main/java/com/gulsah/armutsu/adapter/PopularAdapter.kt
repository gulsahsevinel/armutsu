package com.gulsah.armutsu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.armutsu.databinding.PopularCardViewBinding
import com.gulsah.armutsu.databinding.ServicesCardViewBinding
import com.gulsah.armutsu.model.Services
import com.squareup.picasso.Picasso

class PopularAdapter(var popularList: List<Services>, var mContext: Context) :
    RecyclerView.Adapter<PopularAdapter.PopularCardHolder>() {

    inner class PopularCardHolder(popularCardViewBinding: PopularCardViewBinding) :
        RecyclerView.ViewHolder(popularCardViewBinding.root) {
        var cardView: PopularCardViewBinding

        init {
            this.cardView = popularCardViewBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularCardHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val layout = PopularCardViewBinding.inflate(layoutInflater, parent, false)
        return PopularCardHolder(layout)
    }

    override fun onBindViewHolder(holder: PopularCardHolder, position: Int) {
        val popular = popularList[position]
        Picasso.get().load(popular.imageUrlServices).into(holder.cardView.popularImageView)
        holder.cardView.servicesObject = popular
    }

    override fun getItemCount(): Int {
        return popularList.size
    }
}
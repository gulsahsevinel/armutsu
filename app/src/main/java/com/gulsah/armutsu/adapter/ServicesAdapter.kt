package com.gulsah.armutsu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.armutsu.databinding.ServicesCardViewBinding
import com.gulsah.armutsu.model.Services

class ServicesAdapter(var allServicesList: List<Services>, var mContext: Context) :
    RecyclerView.Adapter<ServicesAdapter.ServicesCardHolder>() {

    inner class ServicesCardHolder(servicesCardViewBinding: ServicesCardViewBinding) :
        RecyclerView.ViewHolder(servicesCardViewBinding.root) {
        var cardView: ServicesCardViewBinding

        init {
            this.cardView = servicesCardViewBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesCardHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val layout = ServicesCardViewBinding.inflate(layoutInflater, parent, false)
        return ServicesCardHolder(layout)
    }

    override fun onBindViewHolder(holder: ServicesCardHolder, position: Int) {
        val service = allServicesList[position]
        holder.cardView.servicesObject = service
    }

    override fun getItemCount(): Int {
        return allServicesList.size
    }
}
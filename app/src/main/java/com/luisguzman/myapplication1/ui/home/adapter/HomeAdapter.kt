package com.luisguzman.myapplication1.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luisguzman.myapplication1.databinding.ItemDesignBinding
import com.luisguzman.myapplication1.domain.model.Entries

class HomeAdapter(
    private val listItem: List<Entries>,
    val onClick:(String) -> Unit
) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemDesignBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

}
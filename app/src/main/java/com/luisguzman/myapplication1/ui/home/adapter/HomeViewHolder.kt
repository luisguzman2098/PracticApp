package com.luisguzman.myapplication1.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.luisguzman.myapplication1.databinding.ItemDesignBinding
import com.luisguzman.myapplication1.domain.model.Entries

class HomeViewHolder(
    private val binding: ItemDesignBinding,
    val onClick:(String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Entries) {
        val index = item.entries.size

        binding.title.text = item.entries[index].API
        binding.description.text = item.entries[index].Description
        binding.category.text = item.entries[index].Category

        binding.openWebView.setOnClickListener {
            onClick(item.entries[index].Link)
        }
    }
}
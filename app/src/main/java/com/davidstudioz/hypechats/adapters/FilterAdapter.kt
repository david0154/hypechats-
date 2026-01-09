package com.davidstudioz.hypechats.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davidstudioz.hypechats.databinding.ItemFilterBinding
import com.davidstudioz.hypechats.models.FaceFilter
import com.bumptech.glide.Glide

class FilterAdapter(private val onFilterSelect: (FaceFilter) -> Unit) : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {
    private val filters = mutableListOf<FaceFilter>()

    inner class FilterViewHolder(private val binding: ItemFilterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(filter: FaceFilter) {
            binding.apply {
                filterName.text = filter.name
                Glide.with(filterImage)
                    .load(filter.image)
                    .into(filterImage)
                root.setOnClickListener { onFilterSelect(filter) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val binding = ItemFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(filters[position])
    }

    override fun getItemCount() = filters.size

    fun submitList(newFilters: List<FaceFilter>) {
        filters.clear()
        filters.addAll(newFilters)
        notifyDataSetChanged()
    }
}
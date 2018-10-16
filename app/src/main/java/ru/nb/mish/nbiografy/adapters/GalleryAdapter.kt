package ru.nb.mish.nbiografy.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.BindingViewHolder
import ru.nb.mish.nbiografy.components.OnItemClickListener
import ru.nb.mish.nbiografy.databinding.ItemGridImageBinding

class GalleryAdapter(val images: List<String>, val onItemClickListener: OnItemClickListener<String>) : RecyclerView.Adapter<BindingViewHolder<ItemGridImageBinding>>() {

    override fun onBindViewHolder(holder: BindingViewHolder<ItemGridImageBinding>, position: Int) {

        val imageURL = images[position]
        Glide.with(holder.itemView)
                .load(imageURL)
                .apply(RequestOptions().centerCrop())
                .into(holder.mLayoutBinding.imageView)


        holder.itemView.setOnClickListener { onItemClickListener.onItemClick(images[holder.adapterPosition]) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemGridImageBinding> {
        val listItemBinding = DataBindingUtil.inflate<ItemGridImageBinding>(LayoutInflater.from(parent.context),
                R.layout.item_grid_image, parent, false)
        return BindingViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int = images.size
}
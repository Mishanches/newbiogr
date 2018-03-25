package ru.nb.mish.nbiografy.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.BindingViewHolder
import ru.nb.mish.nbiografy.components.OnItemClickListener
import ru.nb.mish.nbiografy.databinding.ItemGridImageBinding
import ru.nb.mish.nbiografy.models.Player


class GalleryAdapter (val images: List<String>, val onItemClickListener: OnItemClickListener<String>): RecyclerView.Adapter<BindingViewHolder<ItemGridImageBinding>>() {
    override fun onBindViewHolder(holder: BindingViewHolder<ItemGridImageBinding>, position: Int) {
        // заполняем данные по игрокам
        val imageURL = images[position]
        Glide.with(holder.itemView)
                .load(imageURL)
                .apply(RequestOptions().centerCrop())
                .into(holder.mLayoutBinding.imageView) // holder - хранит данные (в данном случае - только картинку)
        // itemView - все элементы
        // load(imageURL) - передается URL картинки в данном случае
        // into(holder.mLayoutBinding.imageView) - в какой imageView мы закгружаем картинку



        holder.itemView.setOnClickListener { onItemClickListener.onItemClick(images[holder.adapterPosition]) }  // itemView - картинка + текст
    }

    // создает View для элемента списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemGridImageBinding> {
        val listItemBinding= DataBindingUtil.inflate<ItemGridImageBinding>(LayoutInflater.from(parent.context),
                R.layout.item_grid_image, parent, false)
        return BindingViewHolder(listItemBinding) // создам item и разварачиваем его
    }

    override fun getItemCount(): Int = images.size  // возвращаем кол-во игроков

}
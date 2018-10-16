package ru.nb.mish.nbiografy.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.BindingViewHolder
import ru.nb.mish.nbiografy.components.OnItemClickListener
import ru.nb.mish.nbiografy.databinding.ItemPlayerBinding
import ru.nb.mish.nbiografy.models.Player

class PlayerAdapter(val data: ArrayList<Player>, val onItemClickListener: OnItemClickListener<Player>) : RecyclerView.Adapter<BindingViewHolder<ItemPlayerBinding>>() {

    override fun onBindViewHolder(holder: BindingViewHolder<ItemPlayerBinding>, position: Int) {

        val player = data[position]
        holder.mLayoutBinding.tvPlayer.text = player.name
        holder.mLayoutBinding.ivPlayer.setImageResource(player.image)
        holder.itemView.setOnClickListener { onItemClickListener.onItemClick(data[holder.adapterPosition]) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemPlayerBinding> {
        val listItemBinding = DataBindingUtil.inflate<ItemPlayerBinding>(LayoutInflater.from(parent.context),
                R.layout.item_player, parent, false)
        return BindingViewHolder(listItemBinding)
    }

    override fun getItemCount(): Int = data.size
}
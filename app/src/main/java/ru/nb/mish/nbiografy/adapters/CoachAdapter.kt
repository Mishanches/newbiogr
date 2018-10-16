package ru.nb.mish.nbiografy.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.BindingViewHolder
import ru.nb.mish.nbiografy.databinding.ItemCoachBinding
import ru.nb.mish.nbiografy.models.Coach

class CoachAdapter(val data: ArrayList<Coach>) : RecyclerView.Adapter<BindingViewHolder<ItemCoachBinding>>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemCoachBinding> {
        val listItemBinding = DataBindingUtil.inflate<ItemCoachBinding>(LayoutInflater.from(parent?.context),
                R.layout.item_coach, parent, false)
        return BindingViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemCoachBinding>, position: Int) {
        val coach = data[position]
        holder.mLayoutBinding.tvCoach.text = coach.name
        holder.mLayoutBinding.tvCoachDiscr.text = coach.discrCoach

    }
}
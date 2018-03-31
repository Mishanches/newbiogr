package ru.nb.mish.nbiografy.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ru.nb.mish.nbiografy.R
import ru.nb.mish.nbiografy.components.BindingViewHolder
import ru.nb.mish.nbiografy.databinding.ItemCoachBinding
import ru.nb.mish.nbiografy.models.Coach


class CoachAdapter(val data: ArrayList<Coach>): RecyclerView.Adapter<BindingViewHolder<ItemCoachBinding>>() {

    override fun getItemCount(): Int = data.size // возвращаем кол-во тренеров

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemCoachBinding> {
        val listItemBinding= DataBindingUtil.inflate<ItemCoachBinding>(LayoutInflater.from(parent?.context),
                R.layout.item_coach, parent, false)
        return BindingViewHolder(listItemBinding) // создам item и разварачиваем его
    }


    // создает View для элемента списка
    override fun onBindViewHolder(holder: BindingViewHolder<ItemCoachBinding>, position: Int) {
        // заполняем данные по тренерам
        val coach = data[position]
        holder.mLayoutBinding.tvCoach.text=coach.name // имя
        //holder.mLayoutBinding.ivCoach.setImageResource(coach.image) // картинка
        holder.mLayoutBinding.tvCoachDiscr.text=coach.discrCoach // описание

    }
}
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

// RecyclerView.Adapter<BindingViewHolder<ItemPlayerBinding>> наследуемся от адаптера
// ItemPlayerBinding - сист. класс, который создался с помощью Binding
// этот класс создался на основе xml, в которой мы "обернули " данные в <layout>(это item_player)
class PlayerAdapter(val data: ArrayList<Player>, val onItemClickListener: OnItemClickListener<Player>): RecyclerView.Adapter<BindingViewHolder<ItemPlayerBinding>> (){

   //переопределяем метод onBindViewHolder
    override fun onBindViewHolder(holder: BindingViewHolder<ItemPlayerBinding>, position: Int) {
        // заполняем данные по игрокам: что именно будем подтягивать по игрокам, т.к.
       // в rvPlayers.adapter = PlayerAdapter(arrayListOf) (из PlayersActivity) можно хранить и другие
       // данные по игрокам (например, текс биографии), которые в List мы не используем)
        val player = data[position] // позиция
        holder.mLayoutBinding.tvPlayer.text=player.name // имя
        holder.mLayoutBinding.ivPlayer.setImageResource(player.image) // его картинка (круглая)

       // обработчик нажатий по картинке или тексту, где
       // itemView = картинка + текст
        holder.itemView.setOnClickListener { onItemClickListener.onItemClick(data[holder.adapterPosition]) }
    }

    // создает View для элемента списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemPlayerBinding> {
        val listItemBinding= DataBindingUtil.inflate<ItemPlayerBinding>(LayoutInflater.from(parent.context),
                R.layout.item_player, parent, false)
        return BindingViewHolder(listItemBinding) // создам item и разварачиваем его
    }

    override fun getItemCount(): Int = data.size  // возвращаем кол-во игроков

    }
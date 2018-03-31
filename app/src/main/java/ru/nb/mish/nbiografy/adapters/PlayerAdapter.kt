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

// RecyclerView.Adapter<BindingViewHolder<ItemPlayerBinding>> - наследуемся от адаптера
// ItemPlayerBinding - сист. класс, который создался с помощью Binding
// этот класс создался на основе xml, в которой мы "обернули " данные в <layout>(это item_player)

// создаем класс PlayerAdapter, в конструктор вносим список игроков  и обработчик нажатий по этим игрокам
// и наследуемся от адаптера
class PlayerAdapter(val data: ArrayList<Player>, val onItemClickListener: OnItemClickListener<Player>): RecyclerView.Adapter<BindingViewHolder<ItemPlayerBinding>> (){

   //переопределяем метод onBindViewHolder
    override fun onBindViewHolder(holder: BindingViewHolder<ItemPlayerBinding>, position: Int) {
        // заполняем данные по игрокам: что именно будем отображать по игрокам, т.к.
       // в rvPlayers.adapter = PlayerAdapter(arrayListOf) (из PlayersActivity) можно хранить и другие
       // данные по игрокам (например, текст биографии), которые в List мы не используем)
        val player = data[position] // позиция
        holder.mLayoutBinding.tvPlayer.text=player.name // имя
        holder.mLayoutBinding.ivPlayer.setImageResource(player.image) // его картинка (круглая)
               // сейчас тут отображается круглая иконка игрока и его имя
       // если мы хотим отобразить еще, например, фамилию игрока рядом, то нам нужно
       // 1) создать TextView в item_player с фамилией игрока
       // 2) Создать в конструкторе Player еще один параметр, отвечающий за номер
       // 3) Добавить в PlaterList еще 1 аргумент (в строчке rvPlayers.adapter = PlayerAdapter(arrayListOf()
       // 4) В Person добавить 3-ий параметр (сейчас там 2: имя и картинка)
       // 5) тут прописать - holder.mLayoutBinding.tvPlayer.text=player.surname // фамилия


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
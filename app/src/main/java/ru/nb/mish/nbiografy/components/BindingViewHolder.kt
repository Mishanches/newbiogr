package ru.nb.mish.nbiografy.components

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

// сам класс биндинга
class BindingViewHolder<out B : ViewDataBinding>(val mLayoutBinding: B) : RecyclerView.ViewHolder(mLayoutBinding.root)

// <out B : ViewDataBinding> - унаследовано от ViewDataBinding(получает от лайаута все виды перменных)
// (val mLayoutBinding: B) - конструктор, переадем переменную
// (mLayoutBinding.root) - берем от val mLayoutBinding: B самый верхний View
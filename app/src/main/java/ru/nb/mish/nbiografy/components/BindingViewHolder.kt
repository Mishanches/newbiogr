package ru.nb.mish.nbiografy.components

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView


class BindingViewHolder<out B : ViewDataBinding>(val mLayoutBinding: B) : RecyclerView.ViewHolder(mLayoutBinding.root)


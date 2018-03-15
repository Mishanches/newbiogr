package ru.nb.mish.nbiografy.components

// класс слушает клик
interface OnItemClickListener<T> {
    fun onItemClick (item: T)
}
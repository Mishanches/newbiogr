package ru.nb.mish.nbiografy.models

// используем Player в Адаптере у PlayersListActivity
class Player (image:Int=-1, name:String, val anfasPhoto: Int, val biografyText: String, val imagesList: ArrayList<String>):Person(image, name)

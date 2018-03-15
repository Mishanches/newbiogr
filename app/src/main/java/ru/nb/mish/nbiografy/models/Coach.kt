package ru.nb.mish.nbiografy.models


class Coach(image:Int=-1, name:String):Person(image, name) { // наследуемся от Person
    var discrCoach: String = "" // добавляем новую перменную
    constructor(image:Int=-1, name:String, discrCoach: String ): this(image, name) { // создаем новый конструктор с новой переменной
        this.discrCoach = discrCoach // инициализируем ее
    }
}
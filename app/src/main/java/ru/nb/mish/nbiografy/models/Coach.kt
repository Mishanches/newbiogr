package ru.nb.mish.nbiografy.models

class Coach(image: Int = -1, name: String) : Person(image, name) {
    var discrCoach: String = ""

    constructor(image: Int = -1, name: String, discrCoach: String) : this(image, name) {
        this.discrCoach = discrCoach
    }
}
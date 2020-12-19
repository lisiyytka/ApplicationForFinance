package com.example.mysecondproject

class Field{
    var id: Int = 0
    var category: String = " "
    var loss: Double = 0.0
    var income: Double = 0.0
    var date: String = " "
    var comment: String = " "
    var balance: Double = 0.0
    var password: String = " "
    constructor(category: String,
                loss: Double,
                income: Double,
                date: String,
                comment: String,
                balance: Double,
                password: String) {
        this.category = category
        this.comment = comment
        this.date = date
        this.income = income
        this.loss = loss
        this.balance = balance
        this.password = password
    }
    constructor() {

    }
}
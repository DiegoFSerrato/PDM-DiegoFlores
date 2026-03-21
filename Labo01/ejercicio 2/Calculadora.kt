package com.example.ejercicio2

class Calculadora(
    val Brand: String,
    val yearsLife: Int
) {
    var Price: Double

    init {
        Price = 0.0
    }

    constructor(
        Brand: String,
        yearsLife: Int,
        Price: Double
    ) : this(Brand, yearsLife){
        this.Price = Price
    }

    fun Sum(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    fun Sub(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    fun Mul(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    fun Div(num1: Double, num2: Double): Double {
        if (num2 == 0.0) {
            //println("error: No se puede divir entre 0")
            println("Math error")
            return 0.0
        }
        return num1 / num2
    }
}

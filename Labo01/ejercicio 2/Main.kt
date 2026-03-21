package com.example.ejercicio2

fun main(){
    val calc = Calculadora(
        Brand = "Samsung",
        yearsLife = 5,
        Price = 35.99
    )

    println("---CALCULADORA ${calc.Brand}---")
    println("Años de vida: ${calc.yearsLife}")
    println("Precio: ${calc.Price}")

    println("---OPERACIONES---")
    println("10 + 5 = ${calc.Sum(10.0, 5.0)} \n")
    print("10 - 5 = ${calc.Sub(10.0, 5.0)} \n")
    println("10 * 5 = ${calc.Mul(10.0, 5.0)} \n")
    println("10 / 5 = ${calc.Div(10.0, 5.0)} \n")

    println("Division por 0")
    println("10 / 0 = ${calc.Div(10.0, 0.0)}")

}
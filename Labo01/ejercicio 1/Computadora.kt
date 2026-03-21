package com.example.lib


class Computadora (
    var ram: Int,
    var storage: Int,
    var operatingSystem: String,
    var installedPrograms: List<String>
) {

    fun encenderComputadora (){
        println("Computadora encendida")
    }

    fun apagarComputadora (){
        println("Computadora apagada")
    }

    fun actualizar (newRam: Int, newSto: Int, newOS: String){
        ram = newRam
        storage = newSto
        operatingSystem = newOS
        println("Computadora actualizada")
    }

    fun obtenerProgramas(): List<String> {
        return installedPrograms.filter { it.contains("2026") }
    }
}
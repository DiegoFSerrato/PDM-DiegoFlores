package com.example.ejercicio3

fun main(){
    val ciclo1 = listOf(
        //PDM
        Estudiante("Carlos Perez", "PC-20261", "PDM"),
        Estudiante("Juan Lopez", "LJ-20262", "PDM"),
        Estudiante("Maria Garcia", "GM-20263", "PDM"),

        //AN
        Estudiante("Andrea Ayala","AA-20264","AN"),
        Estudiante("Nicolle Valle","NV-20265","AN"),
        Estudiante("Carlos Castillo","CC-20266","AN"),
        Estudiante("Estefania Torres","TE-20267","AN"),
        Estudiante("Luis Salvador","SL-20268","AN")
    )

    println("Estudiantes de PDM")
    val PDM = ciclo1.filter { it.asignatura == "PDM" }
    PDM.forEach { println("Nombre: ${it.nombre} | Carnet: ${it.carnet}")
    }

    println("\n Total de estudiantes de PDM: ${PDM.size}")
}
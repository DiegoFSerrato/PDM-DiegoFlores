package com.example.lib

fun main(){
        val programs = listOf("Notion 2026", "Facebook 2024", "Spotify 2026", "Chrome 2026")

        val compu = Computadora(
            ram = 16,
            storage = 256,
            operatingSystem = "Windows",
            installedPrograms = programs
        )

        //encender
        compu.encenderComputadora()

        // Datos iniciales
        println( "--- Datos iniciales ---")
        println( "RAM: ${compu.ram} GB")
        println( "Almacenamiento: ${compu.storage} GB")
        println( "Sistema Operativo: ${compu.operatingSystem}")
        println( "Programas del 2026: ${compu.obtenerProgramas()}")

        // Actualizar
        compu.actualizar(32, 512,"MacOS")
        println( "--- Actualizados ---")
        println( "Nueva RAM ${compu.ram} GB")
        println( "Nuevo Almacenamiento ${compu.storage} GB")
        println( "Nuevo Sistema Operativo ${compu.operatingSystem}")

        // Apagar
        compu.apagarComputadora()
    }

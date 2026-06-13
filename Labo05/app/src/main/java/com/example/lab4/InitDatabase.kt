package com.example.lab4

import android.app.Application
import androidx.room.Room
import com.example.lab4.data.AppDatabase

class InitDatabase : Application() {
    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "AppDatabase"
        )
        .fallbackToDestructiveMigration()
        .build()
    }
}

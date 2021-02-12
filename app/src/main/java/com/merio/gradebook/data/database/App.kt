package com.merio.gradebook.data.database

import android.app.Application
import androidx.room.Room
import com.merio.gradebook.data.authorization.PasswordStorage

class App : Application() {

    private var database: SubjectDatabase? = null

    override fun onCreate() {
        super.onCreate()
        PasswordStorage.init(this)
        setupDatabase()
    }

    private fun setupDatabase() {
        database = Room.databaseBuilder(
            applicationContext,
            SubjectDatabase::class.java,
            "database"
        )
            .allowMainThreadQueries()
            .build()
    }

    fun getDatabase(): SubjectDatabase {
        if (database == null) {
            setupDatabase()
        }
        return database as SubjectDatabase
    }
}
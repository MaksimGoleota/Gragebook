package com.merio.gradebook.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GradeBook::class], version = 1, exportSchema = false)
abstract class SubjectDatabase : RoomDatabase() {

    abstract fun subjectDao(): Dao
}
package com.merio.gradebook.data.database

import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSubject(subject: GradeBook)

    @Query("SELECT * FROM gradebook")
    fun getAll(): List<GradeBook>

    @Update
    fun updateSubject(subject: GradeBook)

    @Delete
    fun deleteSubject(subject: GradeBook)




}
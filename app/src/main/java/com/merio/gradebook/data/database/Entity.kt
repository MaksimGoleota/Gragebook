package com.merio.gradebook.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gradebook")
class GradeBook(
@PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var mark:Int? = null,
    var subject: String
)

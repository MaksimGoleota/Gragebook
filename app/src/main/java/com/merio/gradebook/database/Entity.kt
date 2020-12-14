package com.merio.gradebook.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gradebook")
class Gradebook(
@PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var mark:Int? = null
)

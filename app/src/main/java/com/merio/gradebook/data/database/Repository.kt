package com.merio.gradebook.data.database

class Repository(private val gradebook: Dao) {

    fun createSubject(subject: GradeBook) = gradebook.addSubject(subject)

}
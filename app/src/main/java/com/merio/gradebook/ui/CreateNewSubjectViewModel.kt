package com.merio.gradebook.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.merio.gradebook.data.database.App
import com.merio.gradebook.data.database.GradeBook
import com.merio.gradebook.data.database.Repository

class CreateNewSubjectViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository(
        (application as App).getDatabase().subjectDao()
    )

    fun createSubject(subject: GradeBook) {
        repository.createSubject(subject)
    }
}
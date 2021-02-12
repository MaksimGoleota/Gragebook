package com.merio.gradebook.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.merio.gradebook.R
import com.merio.gradebook.data.database.GradeBook

class ListSubjectFragment: Fragment() {

    private lateinit var mViewModel: CreateNewSubjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_subject_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
            .getInstance(requireActivity().application)).get(CreateNewSubjectViewModel::class.java)
        showDialog()
    }

    private fun showDialog() {

        val li = LayoutInflater.from(context)
        val promptsView: View = li.inflate(R.layout.alert_dialog, null)
        val alertDialogBuilder = AlertDialog.Builder(context)
        val userInput = promptsView.findViewById<View>(R.id.etUserInput) as EditText


        alertDialogBuilder.setView(promptsView)
        alertDialogBuilder
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, _ ->
                mViewModel.createSubject(GradeBook(subject = userInput.text.toString()))

                Toast.makeText(context, "Предмет успешно добавлен!",
                    Toast.LENGTH_LONG).show()
            }
            .setNegativeButton(
                "Отмена"
            ) { dialog, _ ->
                dialog.cancel() }

        val alertDialog = alertDialogBuilder.create()

        alertDialog.show()

    }
}
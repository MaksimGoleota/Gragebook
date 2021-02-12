package com.merio.gradebook.ui.authorization

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.merio.gradebook.R
import com.merio.gradebook.data.authorization.PasswordStorage
import kotlinx.android.synthetic.main.authorization_fragment.*

class AuthorizationFragment: Fragment() {

    private val password = PasswordStorage.getPassword()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.authorization_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val enteredPassword = password_authorization

        if(password.isEmpty()) {
            Toast.makeText(context, "Пароль не создан!",
                Toast.LENGTH_LONG).show()

            val li = LayoutInflater.from(context)
            val promptsView: View = li.inflate(R.layout.alert_dialog_for_password, null)
            val alertDialogBuilder = AlertDialog.Builder(context)

            alertDialogBuilder.setView(promptsView)
            val userInput = promptsView.findViewById<View>(R.id.etUserInput_2) as EditText

            alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Oк") { dialog, _ ->

                    PasswordStorage.savePassword(userInput.text.toString())
                    Toast.makeText(context, "Пароль успешно создан!",
                        Toast.LENGTH_LONG
                    ).show()
                    findNavController().navigate(R.id.listSubjectFragment)
                }
                .setNegativeButton(
                    "Отмена"
                ) { dialog, _ -> dialog.cancel() }

            val alertDialog = alertDialogBuilder.create()

            alertDialog.show()
        }

        btn_start.setOnClickListener {
        if (password == enteredPassword.text.toString()) {
            Toast.makeText(context, "Авторизация прошла успешна!",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.listSubjectFragment)
        } else{
            Toast.makeText(context, "Пароль введён не верно, повторите попытку",
                Toast.LENGTH_LONG).show()
        }

        }
    }
}
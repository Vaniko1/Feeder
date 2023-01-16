package com.example.spoty.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.spoty.R
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordFragment : Fragment(R.layout.fragment_change_password) {

    private lateinit var textNewPasswordOne: EditText
    private lateinit var buttonChangePasswordTwo: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textNewPasswordOne = view.findViewById(R.id.textNewPasswordOne)
        buttonChangePasswordTwo = view.findViewById(R.id.buttonChangePasswordTwo)
        val controller = Navigation.findNavController(view)


        registerListeners()

    }

    private fun registerListeners(){
        buttonChangePasswordTwo.setOnClickListener {
            val newPassword = textNewPasswordOne.text.toString()

            if (newPassword.isEmpty()){
                Toast.makeText(activity, "Password is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (newPassword.length < 6){
                Toast.makeText(activity, "Password is too short, it must contain 6 symbol!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!(newPassword.matches(".*[0-9].*".toRegex()))){
                Toast.makeText(activity, "Password must contain numbers!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!(newPassword.matches(".*[A-Z].*".toRegex())) && !(newPassword.matches((".*[a-z].*".toRegex())))){
                Toast.makeText(activity, "Password must contain capital and small letters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!(newPassword.matches(".*[!@#$%?_+=].*".toRegex()))){
                Toast.makeText(activity, "Password must contain special symbol!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(activity, "Success!", Toast.LENGTH_SHORT).show()
                        val controller = view?.let { it1 -> Navigation.findNavController(it1) }
                    } else {
                        Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
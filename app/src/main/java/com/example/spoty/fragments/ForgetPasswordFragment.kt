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

class ForgetPasswordFragment: Fragment(R.layout.fragment_forget_password)  {
    private lateinit var textEmailThree: EditText
    private lateinit var buttonEmailOne: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = Navigation.findNavController(view)

        textEmailThree = view.findViewById(R.id.textEmailThree)
        buttonEmailOne = view.findViewById(R.id.buttonEmailOne)

        registerListeners()
    }

    private fun registerListeners(){
        buttonEmailOne.setOnClickListener {
            val email = textEmailThree.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(activity, "Empty Email!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(activity, "Check Email!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }

}
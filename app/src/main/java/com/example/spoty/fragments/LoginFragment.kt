package com.example.spoty.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.spoty.R
import com.example.spoty.TimeLineActivity
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var textEmailOne: EditText
    private lateinit var textPasswordOne: EditText
    private lateinit var buttonLoginOne: Button
    private lateinit var buttonForgotPassword: Button
    private lateinit var buttonSignUp: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = Navigation.findNavController(view)

        if (FirebaseAuth.getInstance().currentUser != null){
            startActivity(Intent(activity, TimeLineActivity::class.java))
            activity?.finish()
        }

        init()

        loginListeners()

        buttonForgotPassword.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToForgetPasswordFragment()
            controller.navigate(action)
        }

        buttonSignUp.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            controller.navigate(action)
        }


    }

    private fun init() {
        textEmailOne = requireView().findViewById(R.id.textEmailOne)
        textPasswordOne = requireView().findViewById(R.id.textPasswordOne)
        buttonLoginOne = requireView().findViewById(R.id.buttonLoginOne)
        buttonForgotPassword = requireView().findViewById(R.id.buttonForgotPassword)
        buttonSignUp = requireView().findViewById(R.id.buttonSignUp)
    }

    private fun loginListeners() {
        buttonLoginOne.setOnClickListener {
            val email = textEmailOne.text.toString()
            val password = textPasswordOne.text.toString()

            if(email.isEmpty()){
                Toast.makeText(activity, "E-mail is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                Toast.makeText(activity, "Password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        startActivity(Intent(activity, TimeLineActivity::class.java))
                        activity?.finish()
                    } else {
                        Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
            
        }
    }
}
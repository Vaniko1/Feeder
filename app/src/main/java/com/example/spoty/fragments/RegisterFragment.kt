package com.example.spoty.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.spoty.LoginActivity
import com.example.spoty.R
import com.example.spoty.TimeLineActivity
import com.example.spoty.model.UserInfoOne
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var textEmailTwo: EditText
    private lateinit var pass: EditText
    private lateinit var textPasswordTwo: EditText
    private lateinit var buttonSignUpOne: Button
    private lateinit var buttonSignInOne: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = Navigation.findNavController(view)

        textEmailTwo = view.findViewById(R.id.textEmailTwo)
        pass = view.findViewById(R.id.pass)
        textPasswordTwo = view.findViewById(R.id.textPasswordTwo)
        buttonSignUpOne = view.findViewById(R.id.buttonSignUpOne)
        buttonSignInOne = view.findViewById(R.id.buttonSignInOne)

        buttonSignInOne.setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            controller.navigate(action)
        }
        registerListeners()


    }

    private fun registerListeners() {
        buttonSignUpOne.setOnClickListener {
            val email = textEmailTwo.text.toString()
            val password = textPasswordTwo.text.toString()
            val pass = pass.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(activity, "E-mail is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                Toast.makeText(activity, "Password is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(activity, "Invalid E-mail address!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!(email.matches(((".*[[a-zA-Z0-9\\\\+\\\\.\\\\_\\\\%\\\\-\\\\+]{1,256}\" + \"\\\\@\" + " +
                        " \"[a-zA-Z0-9][a-zA-Z0-9\\\\-]{0,64}\" + \"(\" + \"\\\\.\" + " +
                        "\"[a-zA-Z0-9][a-zA-Z0-9\\\\-]{0,25}\" + \")+\"].*").toRegex())))) {
                Toast.makeText(activity, "Not correct E-mail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.length < 6){
                Toast.makeText(activity, "Password is too short, it must contain 6 symbol!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!(password.matches(".*[0-9].*".toRegex()))){
                Toast.makeText(activity, "Password must contain numbers!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!(password.matches(".*[A-Z].*".toRegex())) && !(password.matches((".*[a-z].*".toRegex())))){
                Toast.makeText(activity, "Password must contain capital and small letters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!(password.matches(".*[!@#$%?_+=].*".toRegex()))){
                Toast.makeText(activity, "Password must contain special symbol!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != pass){
                Toast.makeText(activity, "Passwords must match!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(activity, TimeLineActivity::class.java))
                        activity?.finish()
                    } else {
                        Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}

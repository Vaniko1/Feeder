package com.example.spoty.fragments

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.spoty.LoginActivity
import com.example.spoty.R
import com.example.spoty.model.UserInfoOne
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import org.w3c.dom.Text

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var textViewID: TextView
    private lateinit var textFullName: TextView
    private lateinit var buttonLogOutOne: Button
    private lateinit var textNewPasswordOne: EditText
    private lateinit var buttonChangePasswordTwo: Button
    private lateinit var note: EditText
    private lateinit var button: Button
    private lateinit var text : TextView
    private lateinit var clear : TextView

    private lateinit var  sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogOutOne = view.findViewById(R.id.buttonLogOutOne)
        textViewID = view.findViewById(R.id.textViewID)
        textFullName = view.findViewById(R.id.textFullName)
        textNewPasswordOne = view.findViewById(R.id.textNewPasswordOne)
        buttonChangePasswordTwo = view.findViewById(R.id.buttonChangePasswordTwo)
        note = view.findViewById(R.id.note)
        button = view.findViewById(R.id.add)
        text = view.findViewById(R.id.textView3)
        clear = view.findViewById(R.id.clear)


        sharedPreferences  = requireActivity().getSharedPreferences("my pref", MODE_PRIVATE)
        val prefNote = sharedPreferences.getString("NOTE","")
        text.text = prefNote

        button.setOnClickListener {
            val noted = note.text.toString()

            if(noted.isNullOrEmpty()){
                return@setOnClickListener
            }
            val notes = text.text.toString()
            val resultText = notes + '\n' + noted
            text.text = resultText
            note.setText("")


            sharedPreferences.edit()
                .putString("Song", resultText)
                .apply()
        }

        clear.setOnClickListener{
            text.text = ""
            Toast.makeText(activity, "Cleared", Toast.LENGTH_SHORT).show()
        }

        registerListeners()
        buttonLogOutOne.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }
        textViewID.text = FirebaseAuth.getInstance().currentUser?.uid


        val userEmail = FirebaseAuth.getInstance().currentUser?.email
        textFullName.text = userEmail
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
                    } else {
                        Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}

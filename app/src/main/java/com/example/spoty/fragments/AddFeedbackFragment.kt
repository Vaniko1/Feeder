package com.example.spoty.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.spoty.R
import com.example.spoty.model.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AddFeedbackFragment : Fragment(R.layout.fragment_add_feedback) {

    private lateinit var ArtistSongText : EditText
    private lateinit var AddCommentText : EditText
    private lateinit var postButton : Button

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rateApp: TextView = view.findViewById(R.id.rateApp)

        rateApp.setOnClickListener{
            val showPopUp = CustomDialogFragment()
            showPopUp.show((activity as AppCompatActivity).supportFragmentManager, "ShowPopUp")
        }

        init()


        postInformation()

    }

    private fun init(){
        ArtistSongText = requireView().findViewById(R.id.ArtistSongText)
        AddCommentText = requireView().findViewById(R.id.AddCommentText)
        postButton = requireView().findViewById(R.id.postButton)
    }

    private fun postInformation() {
        postButton.setOnClickListener {
            val textOne = ArtistSongText.text.toString()
            val textTwo = AddCommentText.text.toString()
            db.child(auth.currentUser?.uid!!).get().addOnSuccessListener {
                val postFeed = ArtistSongText.text.toString()
                if (postFeed.isNotEmpty()) {
                    val id = db.push().key
                    db.child(id.toString()).child("SongName").setValue(textOne)
                    db.child(id.toString()).child("FeedBack").setValue(textTwo)
                    Toast.makeText(activity, "The post is published", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(activity, "Fail", Toast.LENGTH_LONG).show()

                }
                }
            }
        }



}

package com.example.spoty.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spoty.R
import com.example.spoty.adapter.RecyclerViewPostAdapter
import com.example.spoty.model.News
import com.example.spoty.model.UserInfo
import com.google.firebase.database.*


class SongsFragment : Fragment(R.layout.fragment_songs) {

    private lateinit var adapter: RecyclerViewPostAdapter
    private lateinit var reference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recv)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        database = FirebaseDatabase.getInstance()
        reference = database.getReference("UserInfo")

        getData()

        dataInitialize()

    }


    private fun getData(){
        reference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                var list= ArrayList<UserInfo>()
                for(data in snapshot.children){
                    var model = data.getValue(UserInfo::class.java)
                    list.add(model as UserInfo)
                }
                if (list.size>0){
                    val adapter= RecyclerViewPostAdapter(list)
                    recyclerView.adapter = adapter
                }

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun dataInitialize(){

        newsArrayList = arrayListOf<News>()

            imageId = arrayOf(
                R.drawable.ic_baseline_music_note_24,
                R.drawable.ic_baseline_music_note_24,
                R.drawable.ic_baseline_music_note_24,
                R.drawable.ic_baseline_music_note_24,
                R.drawable.ic_baseline_music_note_24
            )
            heading = arrayOf(
                getString(R.string.app_name),
                getString(R.string.google_api_key),
                getString(R.string.default_web_client_id),
                getString(R.string.gcm_defaultSenderId),
                getString(R.string.google_app_id)
            )
            news = arrayOf(
                getString(R.string.app_name),
                getString(R.string.google_api_key),
                getString(R.string.default_web_client_id),
                getString(R.string.gcm_defaultSenderId),
                getString(R.string.google_app_id)
            )
            for (i in imageId.indices){
                val news = News(imageId[i], heading[i])
                newsArrayList.add(news)
            }

    }




}
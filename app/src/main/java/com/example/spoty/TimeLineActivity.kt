package com.example.spoty

import android.net.wifi.p2p.nsd.WifiP2pUpnpServiceInfo.newInstance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.spoty.adapter.ViewPagerFragmentAdapter
import com.example.spoty.fragments.SongsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.datepicker.MaterialCalendar.newInstance
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.reflect.Array.newInstance
import java.net.URLClassLoader.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance
import javax.xml.parsers.DocumentBuilderFactory.newInstance
import javax.xml.transform.TransformerFactory.newInstance

class TimeLineActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerFragmentAdapter: ViewPagerFragmentAdapter
    private val navigationItem = NavigationBarView.OnItemSelectedListener {
        when(it.itemId){
            R.id.songsFragment ->{
                viewPager.currentItem = 0
                return@OnItemSelectedListener true
            }
            R.id.addFeedbackFragment ->{
                viewPager.currentItem = 1
                return@OnItemSelectedListener true
            }
            R.id.profileFragment ->{
                viewPager.currentItem = 2
                return@OnItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_line)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()


        viewPager = findViewById(R.id.viewPager)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        viewPagerFragmentAdapter = ViewPagerFragmentAdapter(this)
        viewPager.adapter = viewPagerFragmentAdapter
        bottomNavigationView.setOnItemSelectedListener(navigationItem)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position){
                    0 -> bottomNavigationView.menu.findItem(R.id.songsFragment).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.addFeedbackFragment).isChecked = true
                    2 -> bottomNavigationView.menu.findItem(R.id.profileFragment).isChecked = true
                }
            }
        })
        fun onBackPressed() {
        if (viewPager.currentItem == 0){
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }
}

}

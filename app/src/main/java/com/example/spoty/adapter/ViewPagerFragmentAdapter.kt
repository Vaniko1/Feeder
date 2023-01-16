package com.example.spoty.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.spoty.TimeLineActivity
import com.example.spoty.fragments.*

class ViewPagerFragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> SongsFragment()
            1 -> AddFeedbackFragment()
            2 -> ProfileFragment()
            else -> ChangePasswordFragment()
        }
    }

}
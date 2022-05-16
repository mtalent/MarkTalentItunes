package com.assignment.marktalentitunes

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.assignment.marktalentitunes.api.ApiService
import com.assignment.marktalentitunes.model.ResultSongListing
import com.assignment.marktalentitunes.view.SongAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    lateinit var rvSongList: RecyclerView
    lateinit var songAdapter: SongAdapter

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {FirstFragment()}
            1 -> {
                SecondFragment()
            }
            2 -> {
                ThirdFragment()
            }
            else -> {throw Resources.NotFoundException("Position Not Found")}
        }

    }


}
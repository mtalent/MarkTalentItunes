package com.assignment.marktalentitunes

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.assignment.marktalentitunes.api.ApiService
import com.assignment.marktalentitunes.model.ResultSongListing
import com.assignment.marktalentitunes.view.SongAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var tabLayout: TabLayout
private lateinit var viewPager: ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = PagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "Classic"
                }
                1 -> {
                    "Rock"
                }
                2 -> {
                    "Pop"
                }
                else -> {
                    throw Resources.NotFoundException("Position Not Found")
                }


            }
            tab.icon = when (index) {
            0 -> {
                getDrawable(R.drawable.ic_music_note)
            }
            1 -> {
                getDrawable(R.drawable.ic_music_note)
            }
            2 -> {
                getDrawable(R.drawable.ic_music_note)
            }
            else -> {
                throw Resources.NotFoundException("Position Not Found")
            }

            }




        }.attach()




    }



}

package com.assignment.marktalentitunes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.assignment.marktalentitunes.api.ApiService
import com.assignment.marktalentitunes.model.ResultSongListing
import com.assignment.marktalentitunes.view.SongAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class FirstFragment : Fragment() {

    lateinit var rvSongList: RecyclerView
    lateinit var songAdapter: SongAdapter





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        rvSongList = view.findViewById(R.id.rv_song_list)
        startRetrofit()

        // Inflate the layout for this fragment
        return view //inflater.inflate(R.layout.fragment_first, container, false)
    }


    private fun startRetrofit() {
        ApiService.createRetrofit().create(ApiService::class.java).getSongListing()
            .enqueue(object : Callback<ResultSongListing> {
                override fun onResponse(
                    call: Call<ResultSongListing>,
                    response: Response<ResultSongListing>
                ) {
                    if (response.isSuccessful) {
                        songAdapter = SongAdapter(response.body()!!.results)
                        rvSongList.adapter = songAdapter
                    }
                }

                override fun onFailure(call: Call<ResultSongListing>, t: Throwable) {

                }

            })
    }





}
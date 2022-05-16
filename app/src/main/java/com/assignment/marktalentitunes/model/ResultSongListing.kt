package com.assignment.marktalentitunes.model

data class ResultSongListing(
    val results: List<SongListing>
)

data class SongListing(
    val artistName : String,
    val collectionName : String,
    val artworkUrl60 : String,
    val trackPrice : String
)

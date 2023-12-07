package com.farad.entertainment.btmanfilm.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class FilmBatmanModel(
    @SerializedName(  "Response")
    val response: String,
    @SerializedName(  "Search")
    val search: List<BatmanSearch>,
    @SerializedName(  "totalResults")
    val totalResults: String
)


@Parcelize
data class BatmanSearch(
    @SerializedName( "imdbID")
    val imdbID: String,
    @SerializedName(  "Poster")
    val poster: String,
    @SerializedName(  "Title")
    val title: String,
    @SerializedName(  "Type")
    val type: String,
    @SerializedName(  "Year")
    val year: String
): Parcelable
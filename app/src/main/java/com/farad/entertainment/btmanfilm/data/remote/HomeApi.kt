package com.farad.entertainment.btmanfilm.data.remote

import com.farad.entertainment.btmanfilm.data.model.DetailBatmanFilm
import com.farad.entertainment.btmanfilm.data.model.FilmBatmanModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {
    @GET("?apikey=3e974fca&s=batman")
    suspend fun getListFilmBatman(): Response<FilmBatmanModel>

    @GET("/")
    suspend fun getDetailFilmBatman(
        @Query("apikey") apiKey: String = "3e974fca",
        @Query("i") movieId: String
    ): Response<DetailBatmanFilm>
}
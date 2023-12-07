package com.farad.entertainment.btmanfilm.data.repository

import com.farad.entertainment.btmanfilm.data.model.DetailBatmanFilm
import com.farad.entertainment.btmanfilm.data.model.FilmBatmanModel
import retrofit2.Response

interface HomeRepository {


    suspend fun getListFilmBatman(): Response<FilmBatmanModel>
    suspend fun saveFilmList(filmBatmanModel: FilmBatmanModel)
    suspend fun getListFilmBatmanLocal(): FilmBatmanModel?

    suspend fun getDetailFilmBatman(imdbID: String): Response<DetailBatmanFilm>

}
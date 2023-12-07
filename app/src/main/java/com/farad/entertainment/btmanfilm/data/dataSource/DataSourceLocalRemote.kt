package com.farad.entertainment.btmanfilm.data.dataSource

import com.farad.entertainment.btmanfilm.data.remote.HomeApi

class DataSourceLocalRemote(

  private val homeApi: HomeApi
) {


    suspend fun getListFirmBatman() =homeApi.getListFilmBatman()

    suspend fun getDetailFilmBatman(imdbID :String) = homeApi.getDetailFilmBatman(movieId = imdbID)

}
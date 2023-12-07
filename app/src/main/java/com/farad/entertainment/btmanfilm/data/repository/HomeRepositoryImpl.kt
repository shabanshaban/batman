package com.farad.entertainment.btmanfilm.data.repository

import com.farad.entertainment.btmanfilm.data.dataSource.DataSourceLocalHome
import com.farad.entertainment.btmanfilm.data.dataSource.DataSourceLocalRemote
import com.farad.entertainment.btmanfilm.data.model.FilmBatmanModel
import retrofit2.Response

class HomeRepositoryImpl(
    private val local: DataSourceLocalHome,
    private val remote: DataSourceLocalRemote
) : HomeRepository {


    override suspend fun getListFilmBatman(): Response<FilmBatmanModel> {

        return remote.getListFirmBatman()
    }

    override suspend fun saveFilmList(filmBatmanModel: FilmBatmanModel) {
        local.saveFilmList(filmBatmanModel)
    }

    override suspend fun getListFilmBatmanLocal() = local.getListFilmBatmanLocal()

    override suspend fun getDetailFilmBatman(imdbID: String) = remote.getDetailFilmBatman(imdbID)


}
package com.farad.entertainment.btmanfilm.data.dataSource

import com.farad.entertainment.btmanfilm.data.db.MainDatabase
import com.farad.entertainment.btmanfilm.data.model.FilmBatmanModel
import com.farad.entertainment.btmanfilm.data.model.modeldb.toEntity
import com.farad.entertainment.btmanfilm.data.model.modeldb.toModel

class DataSourceLocalHome(
    private val mainDatabase: MainDatabase,
) {

    suspend fun getListFilmBatmanLocal() = mainDatabase.filmBatmanDao().getFilmBatman()?.toModel()

    suspend fun saveFilmList(filmBatmanModel: FilmBatmanModel) =
        mainDatabase.filmBatmanDao().insert(filmBatmanModel.toEntity())
}
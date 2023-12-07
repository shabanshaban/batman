package com.farad.entertainment.btmanfilm.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.farad.entertainment.btmanfilm.base.BaseDao
import com.farad.entertainment.btmanfilm.data.model.modeldb.FilmBatmanModelEntity


@Dao
abstract class BatmanDao : BaseDao<FilmBatmanModelEntity>() {
    @Query("SELECT * FROM  tbl_film")
    abstract fun getFilmBatmanLiveData(): LiveData<List<FilmBatmanModelEntity>>

     @Query("SELECT * FROM tbl_film  ")
     abstract suspend fun getFilmBatman():FilmBatmanModelEntity?
}
package com.farad.entertainment.btmanfilm.data.model.modeldb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.farad.entertainment.btmanfilm.data.model.BatmanSearch
import com.farad.entertainment.btmanfilm.data.model.FilmBatmanModel

@Entity(tableName = "tbl_film")
data class FilmBatmanModelEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Id")
    val id: Long=1,
    @ColumnInfo(  "Response")
    val response: String,
    @ColumnInfo(  "Search")
    val search: List<BatmanSearch>,
    @ColumnInfo(  "totalResults")
    val totalResults: String
)




fun FilmBatmanModelEntity.toModel(): FilmBatmanModel {
  return  FilmBatmanModel(response, search, totalResults)
}

fun FilmBatmanModel.toEntity(): FilmBatmanModelEntity {
   return FilmBatmanModelEntity(1,response, search, totalResults)
}


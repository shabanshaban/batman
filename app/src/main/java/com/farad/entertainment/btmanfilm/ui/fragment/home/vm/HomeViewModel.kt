package com.farad.entertainment.btmanfilm.ui.fragment.home.vm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farad.entertainment.btmanfilm.data.model.DetailBatmanFilm
import com.farad.entertainment.btmanfilm.data.model.FilmBatmanModel
import com.farad.entertainment.btmanfilm.data.repository.HomeRepository
import com.farad.entertainment.btmanfilm.utill.isNetworkAvailable
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {


    val listFilmBatmanLiveData: LiveData<FilmBatmanModel>
        get() = _listFilmBatmanLiveData
    private val _listFilmBatmanLiveData = MutableLiveData<FilmBatmanModel>()

    val detailBatmanFilmLiveData: LiveData<DetailBatmanFilm>
        get() = _detailBatmanFilmLiveData
    private val _detailBatmanFilmLiveData = MutableLiveData<DetailBatmanFilm>()


    val errorLiveData: LiveData<String>
        get() = _errorLiveData
    private val _errorLiveData = MutableLiveData<String>()

    val progressLiveData: LiveData<Boolean>
        get() = _progressLiveData
    private val _progressLiveData = MutableLiveData<Boolean>()


    fun getData(context: Context) {
        _progressLiveData.postValue(true)
        viewModelScope.launch {

            if (context.isNetworkAvailable()) {
                homeRepository.getListFilmBatman().let { response ->
                    _progressLiveData.postValue(false)
                    if (response.isSuccessful) {
                        response.body()?.let { filmBatmanModel ->
                            homeRepository.saveFilmList(filmBatmanModel)
                            _listFilmBatmanLiveData.postValue(filmBatmanModel)
                        }

                    } else {
                        _errorLiveData.postValue(response.message().toString())
                    }

                }
            } else {

                homeRepository.getListFilmBatmanLocal()?.let {
                    _progressLiveData.postValue(false)
                    _listFilmBatmanLiveData.postValue(it)
                }
            }


        }
    }

    fun getDetailsFilm(context: Context, id: String) {
        _progressLiveData.postValue(true)

        viewModelScope.launch {

            if (context.isNetworkAvailable()) {
                homeRepository.getDetailFilmBatman(id).let { response ->
                    _progressLiveData.postValue(false)
                    if (response.isSuccessful) {
                        response.body()?.let { filmBatmanModel ->

                            _detailBatmanFilmLiveData.postValue(filmBatmanModel)
                        }
                    } else {
                        _errorLiveData.postValue(response.message().toString())
                    }
                }
            } else {
                _progressLiveData.postValue(false)
            }
        }
    }
}
package com.farad.entertainment.btmanfilm.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.farad.entertainment.btmanfilm.base.BaseFragment
import com.farad.entertainment.btmanfilm.data.model.FilmBatmanModel
import com.farad.entertainment.btmanfilm.databinding.FragmentHomeBinding
import com.farad.entertainment.btmanfilm.ui.fragment.home.vm.HomeViewModel
import com.farad.entertainment.btmanfilm.utill.isNull
import com.farad.entertainment.btmanfilm.utill.visibleOrGone
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModel<HomeViewModel>()

    private val batmanFilmAdapter = BatmanFilmAdapter()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setup() {
        initRecyclerview()
        getListFilm()

    }

    private fun getListFilm() {
        if (viewModel.listFilmBatmanLiveData.value.isNull())
            viewModel.getData(requireNotNull(context))
    }


    private fun initRecyclerview() {
        binding.recyclerview.adapter = batmanFilmAdapter.apply {
            setOnItemClickListener { search ->
                val navigate = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(search)
                navigate(navigate)
            }
        }
    }

    private fun setData(filmBatmanModel: FilmBatmanModel) {
        batmanFilmAdapter.submitList(filmBatmanModel.search)
    }

    override fun initObserveViewModel() {
        viewModel.listFilmBatmanLiveData.observe(this) {
            setData(it)
        }
        viewModel.errorLiveData.observe(this) {
            Toast.makeText(requireNotNull(context), "خطا در دریافت اطلاعات !", Toast.LENGTH_SHORT)
                .show()
        }
        viewModel.progressLiveData.observe(this) {

            binding.progress.visibleOrGone(it)
        }
    }
}
package com.farad.entertainment.btmanfilm.ui.fragment.details

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.farad.entertainment.btmanfilm.base.BaseFragment
import com.farad.entertainment.btmanfilm.data.model.DetailBatmanFilm
import com.farad.entertainment.btmanfilm.databinding.FragmentDetailsBinding
import com.farad.entertainment.btmanfilm.ui.fragment.home.vm.HomeViewModel
import com.farad.entertainment.btmanfilm.utill.loadImage
import com.farad.entertainment.btmanfilm.utill.visibleOrGone
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    private val viewModel by viewModel<HomeViewModel>()

    private val args by navArgs<DetailsFragmentArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    override fun setup() {
        getArgument()
    }

    private fun getArgument() {
        args.batmanSearch.also { btman ->
            binding.imageFilm.loadImage(btman.poster)
            binding.tvTitle.text = btman.title
            binding.tvYear.text = btman.year
            getDetailFilm()
        }
    }

    private fun getDetailFilm() {
        viewModel.getDetailsFilm(requireNotNull(context), args.batmanSearch.imdbID)
    }


    private fun setData(btman: DetailBatmanFilm) {

        binding.imageFilm.loadImage(btman.poster)
        binding.tvTitle.text = btman.title
        binding.tvYear.text = btman.year
        binding.tvGenre.text = btman.genre
        binding.tvReleased.text = btman.released
        binding.tvRuntime.text = btman.runtime
        binding.tvDirector.text = btman.director
        binding.tvWriter.text = btman.director
        binding.tvActors.text = btman.actors
        binding.tvCountry.text = btman.country
        binding.tvAwards.text = btman.awards
        binding.tvPlot.text = btman.plot
    }

    override fun initObserveViewModel() {
        viewModel.detailBatmanFilmLiveData.observe(this) {
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
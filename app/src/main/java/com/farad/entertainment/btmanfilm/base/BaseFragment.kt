package com.farad.entertainment.btmanfilm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.farad.entertainment.btmanfilm.utill.hideKeyboard
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding > :
    Fragment(),
    FragmentCreateView,
    FragmentNavigate {

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
    private var _binding: VB? = null

    protected val binding: VB
        get() = _binding!!


    private fun closeKeyboard() {
        lifecycleScope.launch {
            delay(1)
            hideKeyboard()
        }
    }


    private fun getNavigator() = findNavController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = bindingInflater.invoke(inflater, container, false)
        beforeCreateView()
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBeforeSetup()
        setup()
        initObserveViewModel()
    }

    override fun initBeforeSetup() {
        //nothing
    }

    abstract fun setup()

    override fun beforeCreateView() {
    }


    override fun initObserveViewModel() {

    }

    override fun navigate(navDirections: NavDirections) {
        view?.hideKeyboard()
        getNavigator().navigate(navDirections)
    }

    override fun navigate(navDirections: NavDirections, extra: FragmentNavigator.Extras) {
        view?.hideKeyboard()
        getNavigator().navigate(navDirections, extra)
    }

    override fun navigate(id: Int) {
        view?.hideKeyboard()
        getNavigator().navigate(id)
    }

    override fun navigate(id: Int, bundle: Bundle) {
        view?.hideKeyboard()
        getNavigator().navigate(id, bundle)
    }

    fun popBackStack() {
        view?.hideKeyboard()
        findNavController().popBackStack()
    }


    fun getBaseActivity(): BaseActivity<*>? {
        return activity as? BaseActivity<*>
    }



    override fun onDestroyView() {
        closeKeyboard()
        super.onDestroyView()
        _binding = null
    }

    fun isNullView(): Boolean = _binding == null

}


interface FragmentCreateView {
    fun beforeCreateView()
    fun initObserveViewModel()
    fun initBeforeSetup()
}

interface FragmentNavigate {
    fun navigate(navDirections: NavDirections)
    fun navigate(navDirections: NavDirections, extra: FragmentNavigator.Extras)
    fun navigate(@IdRes id: Int)
    fun navigate(@IdRes id: Int, bundle: Bundle)

}

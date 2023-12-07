package com.farad.entertainment.btmanfilm.manager

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import com.farad.entertainment.btmanfilm.utill.Click


class NavigationManager(
    private val navHostFragment: NavHostFragment,
) : NavController.OnDestinationChangedListener {




    private var onDestinationChangedListener: Click<NavDestination, Bundle?>? = null


    fun start() {
        stop()
        navHostFragment.navController.addOnDestinationChangedListener(this)
    }

    fun stop() {
        navHostFragment.navController.removeOnDestinationChangedListener(this)
    }

    fun getBackStackEntryCount(): Int {
        return navHostFragment.childFragmentManager.backStackEntryCount
    }






    fun popBackStack(): Boolean {
        return navHostFragment.navController.popBackStack()
    }




    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?,
    ) {
        onDestinationChangedListener?.invoke(destination, arguments)
    }


    fun release() {
        stop()
        onDestinationChangedListener = null
    }
}
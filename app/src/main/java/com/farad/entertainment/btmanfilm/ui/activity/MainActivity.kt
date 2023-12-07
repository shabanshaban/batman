package com.farad.entertainment.btmanfilm.ui.activity

import androidx.navigation.fragment.NavHostFragment
import com.farad.entertainment.btmanfilm.R
import com.farad.entertainment.btmanfilm.base.BaseActivity
import com.farad.entertainment.btmanfilm.base.OnBackPressed
import com.farad.entertainment.btmanfilm.databinding.MainActivityBinding
import com.farad.entertainment.btmanfilm.manager.NavigationManager
import com.farad.entertainment.btmanfilm.utill.isNull

class MainActivity : BaseActivity<MainActivityBinding>() {
    private var navigationManager: NavigationManager? = null
    private var navHostFragment: NavHostFragment? = null

    /**
     *  سلام چون پروژه ی کوچک بود خیلی از تکنوۀوزی هارو داخلش بکار نبردم
     *
     * مرسی خسته نباشید
     */

    override fun getBindingView() = MainActivityBinding.inflate(layoutInflater)

    override fun afterCreateView() {
        super.afterCreateView()
        setupNavigationManager()
    }


    private fun setupNavigationManager() {
        getNavHostFragment(R.id.nav_host_container)?.let {
            navHostFragment = it
            navHostFragment?.let { nav ->
                navigationManager = NavigationManager(nav)
                navigationManager?.start()
            }

        }


    }

    override fun onStart() {
        super.onStart()
        navigationManager?.start()
    }

    override fun onStop() {
        navigationManager?.stop()
        super.onStop()
    }

    override fun onBackPressedCompact() {
        val fragment = navHostFragment?.childFragmentManager?.fragments?.firstOrNull()
        val stackSize = navigationManager?.getBackStackEntryCount() ?: return
        if (stackSize == 0) {
            if (onItemBackPressedListener.isNull())
                super.onBackPressedCompact()
            else onItemBackPressedListener?.invoke()
        } else if (fragment is OnBackPressed)
            fragment.onBackPressedCompact()
        else
            navigationManager?.popBackStack()
    }

    override fun onDestroy() {
        navigationManager?.release()
        navigationManager = null
        super.onDestroy()
    }
}
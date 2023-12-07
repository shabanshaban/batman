package com.farad.entertainment.btmanfilm.base

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(),
    ViewCreatedActivity,
    OnBackPressed {

    lateinit var binding: VB


    protected var onItemBackPressedListener:(()->Unit)?=null
    fun setOnBackPressedListener(listener: ( ) -> Unit) {
        onItemBackPressedListener = listener
    }

    abstract fun getBindingView(): VB

    override fun onCreate(savedInstanceState: Bundle?) {

        beforeCreateView()

        val wic = WindowCompat.getInsetsController(window, window.decorView)
        wic.isAppearanceLightStatusBars = false

        super.onCreate(savedInstanceState)
        binding = getBindingView()
        setContentView(binding.root)
        initBackPressListener()
        afterCreateView()
    }


    override fun afterCreateView() {
    }

    override fun beforeCreateView() {
    }

    override fun onBackPressedCompact() {
        finish()
    }

    fun restart() {
        val intent = intent
        finish()
        startActivity(intent)
    }

    private fun initBackPressListener() {
        onBackPressedDispatcher.addCallback(this, true) {
            onBackPressedCompact()
        }
    }

    fun getNavHostFragment(id: Int): NavHostFragment? {
        return supportFragmentManager.findFragmentById(id) as? NavHostFragment
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}


interface ViewCreatedActivity {

    fun afterCreateView()

    fun beforeCreateView()

}

interface OnBackPressed {
    fun onBackPressedCompact()
}
package com.farad.entertainment.btmanfilm.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import coil.load
import com.farad.entertainment.btmanfilm.R
import com.farad.entertainment.btmanfilm.base.BaseActivity
import com.farad.entertainment.btmanfilm.databinding.SplashActivityBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<SplashActivityBinding>() {

    override fun getBindingView() = SplashActivityBinding.inflate(layoutInflater)

    override fun afterCreateView() {
        super.afterCreateView()

        binding.imageSplash.load(R.drawable.batman)
        lifecycleScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
            finish()
        }
    }
}
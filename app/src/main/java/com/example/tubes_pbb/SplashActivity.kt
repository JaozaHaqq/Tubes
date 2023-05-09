package com.example.tubes_pbb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val pindah = Intent(this, LoginActivity::class.java)
            startActivity(pindah)
            finish()
        }, 3000)// ketika aplikasi pertama kli dibuka dia menuju splashcreen dan akan delay
        // selama 2000s kmdn lgsg menuju halaman login

        //agar saat program dirun munculnya di splass page, kita hrs menyettingnya di manifest
    }
}
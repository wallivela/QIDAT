package com.example.qidat.Views.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.qidat.R
import com.example.qidat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Asociar el activity a un layout
        //setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Configuración para que la animación funcione
        //binding.animationView.setAnimation(R.raw.book_animation)
        binding.animationView.playAnimation()
        //Trancisión entre la animación y la siguiente activity (4S)
        handler= Handler(Looper.myLooper()!!)
        handler.postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },4000)
    }
}

package com.example.llegadasegura.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.llegadasegura.databinding.ActivityRegistro2Binding


class Registro2 : AppCompatActivity() {
    private lateinit var binding: ActivityRegistro2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnContinuar.setOnClickListener{
            cambiarPantallaRegistro3()
        }

    }
    private fun cambiarPantallaRegistro3(){
        var intent = Intent(this, Registro3::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }
}
package com.example.llegadasegura.registro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.llegadasegura.R
import com.example.llegadasegura.databinding.ActivityRegistro5Binding

class Registro5: AppCompatActivity() {
    private lateinit var binding: ActivityRegistro5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistro5Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnContinuar.setOnClickListener{
            cambiarPantallaInicio()
        }
    }
    private fun cambiarPantallaInicio(){
        var intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }
}
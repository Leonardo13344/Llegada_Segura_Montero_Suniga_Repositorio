package com.example.llegadasegura.registro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.llegadasegura.databinding.ActivityRegistro4Binding

class Registro4: AppCompatActivity() {
    private lateinit var binding: ActivityRegistro4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistro4Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnContinuar.setOnClickListener{
            cambiarPantallaRegistro4()
        }
    }
    private fun cambiarPantallaRegistro4(){
        var intent = Intent(this, Registro5::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }
}
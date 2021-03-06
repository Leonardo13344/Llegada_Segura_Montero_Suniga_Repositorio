package com.example.llegadasegura.registro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.llegadasegura.databinding.ActivityRegistro3Binding

class Registro3: AppCompatActivity() {
    private lateinit var binding: ActivityRegistro3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegistro3Binding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnContinuar.setOnClickListener{

            cambiarPantallaRegistro4()
        }

        binding.editTextPhone2.setOnClickListener{
            validar()
        }
    }


    private fun cambiarPantallaRegistro4() {
        var intent = Intent(this, Registro4::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }

    private fun validar(){
        if(binding.editTextPhone.getText().toString().isNotEmpty() && binding.editTextPhone2.getText().toString().isNotEmpty()){
            binding.btnContinuar.setEnabled(true)
        }else{
            binding.btnContinuar.setEnabled(false)
        }
    }
}
package com.example.llegadasegura

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.llegadasegura.databinding.ActivityTerminosResultBinding


class TerminosResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTerminosResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerminosResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAceptar.setOnClickListener{
            setResult(Activity.RESULT_OK)
            finish()
        }

        binding.btnCancelar.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}
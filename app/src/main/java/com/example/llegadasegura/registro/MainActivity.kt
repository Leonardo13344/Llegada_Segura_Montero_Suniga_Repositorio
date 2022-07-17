package com.example.llegadasegura.registro
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.llegadasegura.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            cambiarPantallaRegistro2()
        }
    }
    private fun cambiarPantallaRegistro2(){
        var intent = Intent(this, Registro2::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }
}
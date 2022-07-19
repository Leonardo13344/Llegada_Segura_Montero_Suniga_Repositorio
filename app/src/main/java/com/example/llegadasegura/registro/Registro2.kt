package com.example.llegadasegura.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.llegadasegura.TerminosResultActivity
import com.example.llegadasegura.databinding.ActivityRegistro2Binding


class Registro2 : AppCompatActivity() {
    private lateinit var binding: ActivityRegistro2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnClickListener {
            validar()
        }
        binding.btnContinuar.setOnClickListener{
            cambiarPantallaRegistro3()
        }

        val respuesta = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val message = it.data?.getStringExtra("val")
                Toast.makeText(this,"Funcionó",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnTerminos.setOnClickListener{
            respuesta.launch(Intent(this,TerminosResultActivity::class.java))

        }

    }
    private fun cambiarPantallaRegistro3(){
        var intent = Intent(this, Registro3::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }

    private fun validar(){
        if(binding.checkBox.isChecked && binding.editTextPhone.getText().toString().isNotEmpty()){
            binding.btnContinuar.setEnabled(true)
        }else{
            binding.btnContinuar.setEnabled(false)
        }
    }
}
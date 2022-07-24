package com.example.llegadasegura.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.llegadasegura.TerminosResultActivity
import com.example.llegadasegura.databinding.ActivityRegistro2Binding


class Registro2 : AppCompatActivity() {
      lateinit var binding: ActivityRegistro2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinuar.setOnClickListener{
            cambiarPantallaRegistro3()
        }

        val respuesta = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK && binding.editTextPhone.getText().toString().isNotEmpty()){
                //val message = it.data?.getStringExtra("val")
                binding.checkBox.setChecked(true)
                binding.btnContinuar.setEnabled(true)
                Toast.makeText(this,"Términos aceptados",Toast.LENGTH_SHORT).show()
            }else{
                binding.checkBox.setChecked(false)
                binding.btnContinuar.setEnabled(false)
                Toast.makeText(this,"Términos no aceptados",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnTerminos.setOnClickListener{
            respuesta.launch(Intent(this,TerminosResultActivity::class.java))

        }

    }
    private fun cambiarPantallaRegistro3(){
        val intent = Intent(this, Registro3::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }


}
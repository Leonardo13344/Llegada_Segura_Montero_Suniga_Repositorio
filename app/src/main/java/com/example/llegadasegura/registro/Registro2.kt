package com.example.llegadasegura.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.llegadasegura.databinding.ActivityRegistro2Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Registro2 : AppCompatActivity() {
    private lateinit var binding: ActivityRegistro2Binding
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistro2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnContinuar.setOnClickListener{
            cambiarPantallaRegistro3()
            guardarDato()
        }

    }
    val user = hashMapOf(
        "first" to "Ada",
        "last" to "Lovelace",
        "born" to 1815
    )
    private fun guardarDato(){
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }

    private fun cambiarPantallaRegistro3(){
        var intent = Intent(this, Registro3::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }
}
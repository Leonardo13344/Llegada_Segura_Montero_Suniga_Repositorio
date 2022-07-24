package com.example.llegadasegura.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.llegadasegura.databinding.ActivityRegistro2Binding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Registro2 : AppCompatActivity() {
    private lateinit var binding: ActivityRegistro2Binding
    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance();
    private lateinit var TextNumero: EditText;
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistro2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnContinuar.setOnClickListener {
            cambiarPantallaRegistro3()
            registrarNumero();
            agregarRegistro();
        }
        TextNumero = binding.editTextPhone;
    }

    private fun cambiarPantallaRegistro3() {
        var intent = Intent(this, Registro3::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }
    val user = hashMapOf(
        "first" to "Ada",
        "last" to "Lovelace",
        "born" to 1815
    )
    private fun agregarRegistro(){
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("Tag", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }
    private fun registrarNumero() {
        var numero: String = TextNumero.text.toString().trim();

        if (TextUtils.isEmpty(numero)) {
            Toast.makeText(this, "Se debe ingresar un número", Toast.LENGTH_LONG).show();
            return
        }

        this.mAuth.createUserWithEmailAndPassword("br-ein@hotmail.com", "a26061996").addOnCompleteListener { task: Task<AuthResult> ->
            if (task.isSuccessful) {
                Toast.makeText(this,"Se realizo el registro", Toast.LENGTH_SHORT).show()
                val firebaseUser = this.mAuth.currentUser!!
            } else {
                Toast.makeText(this,"No se puede registrar", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
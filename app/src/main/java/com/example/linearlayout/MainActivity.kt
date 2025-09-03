package com.example.linearlayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var email = findViewById<EditText>(R.id.EditTextEmail).text
        var senha = findViewById<EditText>(R.id.EditTextSenha).text
        var btnLogin = findViewById<Button>(R.id.ButtonLogin)
        var btnCadastro = findViewById<Button>(R.id.ButtonCadastro)

        btnCadastro.setOnClickListener{
           var x =  Intent(this,Cadastro::class.java)
            startActivity(x)
        }

        btnLogin.setOnClickListener{

            if (email.toString().equals("email@gmail.com") && senha.toString().equals("123")) {
                var intent = Intent(this, Seguros::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Usuario ou senha invalidos", Toast.LENGTH_LONG).show()
            }
        }


    }
}
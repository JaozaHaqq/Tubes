package com.example.tubes_pbb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.util.Linkify
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val savedLogin = getSharedPreferences("Login", MODE_PRIVATE)
        val editSavedLogin = savedLogin.edit()
        if (savedLogin.getString("Status", "Off")=="On"){
            startActivity(Intent(this, MainActivity::class.java))
        }

        val editUsername: EditText = findViewById(R.id.emaill)
        val editPassword: EditText = findViewById(R.id.pass_login)
        val btnLogin: Button = findViewById(R.id.signinBotton)
        val btnRegister: TextView = findViewById(R.id.sign_up_hyperlink)
        val userDBHelper = DBHelper(this)
        btnLogin.setOnClickListener {
            var emailku = editUsername.text.toString()
            var passku = editPassword.text.toString()
            var cekLogin = userDBHelper.cekLogin(emailku, passku)
            if(cekLogin=="1"){
                editSavedLogin.putString("Email", emailku)
                editSavedLogin.putString("Password", passku)
                editSavedLogin.putString("Status", "On")
                editSavedLogin.commit()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val toast: Toast = Toast.makeText(applicationContext,
                    "Gagal Login", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
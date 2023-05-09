package com.example.tubes_pbb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.util.Linkify
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    lateinit var eemail: EditText
    lateinit var epassword: EditText
    lateinit var efullname: EditText
    lateinit var btnregister: Button
    lateinit var btncancel: TextView
    lateinit var userDBHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        eemail = findViewById(R.id.userEmail)
        epassword = findViewById(R.id.password)
        efullname= findViewById(R.id.userEmail)
        btnregister = findViewById(R.id.signupBotton)
        btncancel = findViewById(R.id.sign_in_hyperlink)
        userDBHelper = DBHelper(this)
    }

    fun registerme(view: View){
        var iemail = eemail.text.toString()
        var ipassword = epassword.text.toString()
        var ifullname = efullname.text.toString()

        var cekuser = userDBHelper.cekUser(iemail)
        var status = "Gagal"
        if (cekuser =="0") {
            userDBHelper.RegisterUser(iemail, ipassword, ifullname)
            status = "Sukses"
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        val toast: Toast = Toast.makeText(applicationContext,
            status, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun cancelme(view: View){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
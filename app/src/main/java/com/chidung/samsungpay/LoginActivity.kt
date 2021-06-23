package com.chidung.samsungpay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    val auth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton: Button = findViewById(R.id.loginButton)
        val emailText: TextView = findViewById(R.id.emailField)
        val passwordText: TextView = findViewById(R.id.passwordField)
        emailText.hint = "Email"
        passwordText.hint = "Password"
        loginButton.setOnClickListener {

        }
    }
    fun Login(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password)
    }
}
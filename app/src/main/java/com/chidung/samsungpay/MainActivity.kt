package com.chidung.samsungpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getData: TextView = findViewById(R.id.getData)
        val db = Firebase.firestore
        db.collection("test")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("data",document.data.toString())
                    getData.text = document.data.toString()
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Error getting duments: ", exception.toString())
            }
    }
}
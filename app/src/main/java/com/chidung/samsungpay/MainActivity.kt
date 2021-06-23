package com.chidung.samsungpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.ImageView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.chidung.samsungpay.codeModel
import com.google.firebase.firestore.ktx.toObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image: ImageView = findViewById(R.id.imageView)
        val getData: TextView = findViewById(R.id.getData)
        image.setImageResource(R.drawable.screenshot)
        val db = Firebase.firestore
        db.collection("test").document("zn4zHZEBfOZPglb10ULl")
            .get()
            .addOnSuccessListener { result ->
                val city = result.toObject<codeModel>()
                if (city != null) {
                    getData.text = city.code
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Error getting duments: ", exception.toString())
            }
    }
}
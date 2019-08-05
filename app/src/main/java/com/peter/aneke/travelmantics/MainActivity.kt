package com.peter.aneke.travelmantics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    val firebaseDb: FirebaseDatabase by lazy {FirebaseDatabase.getInstance()}
    val databaseReference : DatabaseReference by lazy { firebaseDb.reference }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

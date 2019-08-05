package com.peter.aneke.travelmantics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.peter.aneke.travelmantics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val firebaseDb: FirebaseDatabase by lazy {FirebaseDatabase.getInstance()}
    val databaseReference : DatabaseReference by lazy { firebaseDb.reference }
    val viewModel : InputViewModel by lazy {ViewModelProviders.of(this).get(InputViewModel::class.java)}
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.input_menu, menu)
        return true
    }
}

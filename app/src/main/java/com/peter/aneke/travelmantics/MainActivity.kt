package com.peter.aneke.travelmantics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.peter.aneke.travelmantics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    val viewModel: InputViewModel by lazy { ViewModelProviders.of(this).get(InputViewModel::class.java) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        viewModel.errorMessage.observe(this, Observer {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.input_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.save_btn -> viewModel.save()
        }
        return super.onOptionsItemSelected(item)
    }
}

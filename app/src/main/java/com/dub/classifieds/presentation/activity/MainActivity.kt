package com.dub.classifieds.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.dub.classifieds.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewsAndListeners()
    }

    private fun initViewsAndListeners() {
        val toolBar: Toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolBar.setNavigationOnClickListener {
            navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        }
    }

}
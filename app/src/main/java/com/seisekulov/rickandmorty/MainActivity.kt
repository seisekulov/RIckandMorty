package com.seisekulov.rickandmorty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navigationView: BottomNavigationView = findViewById(R.id.navigation_view)
        val navigationController = findNavController(R.id.nav_host_fragment_container)
        navigationView.setupWithNavController(navigationController)
    }
}
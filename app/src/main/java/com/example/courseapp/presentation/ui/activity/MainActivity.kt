package com.example.courseapp.presentation.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.courseapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost = supportFragmentManager.findFragmentById(R.id.main_fragment_container) as NavHostFragment
        navController = navHost.navController

        bottomNav = findViewById(R.id.main_navigation_view)
        bottomNav.setOnItemSelectedListener { item ->
            val builder = NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setRestoreState(true)

            val startDest = navController.graph.startDestinationId
            builder.setPopUpTo(startDest, false, saveState = true)

            return@setOnItemSelectedListener try {
                navController.navigate(item.itemId, null, builder.build())
                true
            } catch (_: IllegalArgumentException) {
                false
            }
        }
    }
}
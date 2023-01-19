package com.turtle.multimodulehilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.turtle.multimodulehilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
            bottomNavigation.setupWithNavController(navHostFragment.navController)
            bottomNavigation.setOnItemReselectedListener { }
        }

        // navigation 과 actionbar 연동
//        appBarConfiguration = AppBarConfiguration(
//            setOf(R.id.menu_page_1, R.id.menu_page_2,  R.id.menu_page_3)
//        )
//        setupActionBarWithNavController(this, navHostFragment.navController, appBarConfiguration)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }
}
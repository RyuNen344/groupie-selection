package com.ryunen344.selection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ryunen344.selection.databinding.ActivityContainerBinding
import org.koin.androidx.fragment.android.setupKoinFragmentFactory

class ContainerActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var binding: ActivityContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setupKoinFragmentFactory()
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityContainerBinding>(this, R.layout.activity_container).also {
            it.lifecycleOwner = this
        }

        navController =
            (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController
    }

    override fun onBackPressed() {
        if (onBackPressedDispatcher.hasEnabledCallbacks()) {
        } else {
        }

        super.onBackPressed()
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}

package com.ryunen344.selection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ryunen344.selection.template.R
import com.ryunen344.selection.template.databinding.ActivityContainerBinding

class ContainerActivity : AppCompatActivity() {

    private val navController: NavController by lazy { findNavController(R.id.nav_main) }

    private lateinit var binding: ActivityContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityContainerBinding>(this,
            R.layout.activity_container
        )
            .also {
                it.lifecycleOwner = this@ContainerActivity
            }
    }

    override fun onBackPressed() {
        if (onBackPressedDispatcher.hasEnabledCallbacks()) {
        } else {
        }

        super.onBackPressed()
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}

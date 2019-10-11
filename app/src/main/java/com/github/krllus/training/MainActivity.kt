package com.github.krllus.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.krllus.training.ui.common.NavigationController

class MainActivity : AppCompatActivity() {

    private val navigationController by lazy {
        NavigationController(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            navigationController.navigateToFox("1")
        }
    }
}
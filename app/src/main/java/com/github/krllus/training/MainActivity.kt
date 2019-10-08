package com.github.krllus.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.krllus.training.ui.common.NavigationController
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            navigationController.navigateToFox("1")
        }
    }
}
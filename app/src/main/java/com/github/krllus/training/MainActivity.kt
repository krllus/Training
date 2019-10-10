package com.github.krllus.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.krllus.training.ui.common.NavigationController
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            navigationController.navigateToFox("1")
        }
    }

    override fun androidInjector() = dispatchingAndroidInjector
}
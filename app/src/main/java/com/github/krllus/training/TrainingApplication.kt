package com.github.krllus.training

import android.app.Application
import com.github.krllus.training.dagger.AppComponent
import com.github.krllus.training.dagger.DaggerAppComponent

class TrainingApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()

        appComponent.inject(this)
    }
}
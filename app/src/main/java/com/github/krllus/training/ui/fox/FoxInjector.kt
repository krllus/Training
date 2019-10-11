package com.github.krllus.training.ui.fox

import com.github.krllus.training.TrainingApplication
import com.github.krllus.training.dagger.DaggerFoxComponent

fun FoxFragment.inject() {

    DaggerFoxComponent.builder()
        .appComponent(TrainingApplication.appComponent)
        .fragment(this)
        .build()
        .inject(this)
}
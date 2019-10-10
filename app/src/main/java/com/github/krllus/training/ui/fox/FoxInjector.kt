package com.github.krllus.training.ui.fox

import com.github.krllus.training.dagger.DaggerFoxComponent

fun FoxFragment.inject() {

    DaggerFoxComponent.builder()
        .fragment(this)
        .build()
        .inject(this)
}
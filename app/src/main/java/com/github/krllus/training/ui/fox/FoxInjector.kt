package com.github.krllus.training.ui.fox

import com.github.krllus.training.dagger.FoxModule
import com.github.krllus.training.dagger.NetworkModule

fun FoxFragment.inject() {
    DaggerFoxComponnet.create()
        .foxFragment(this)
        .foxModule(FoxModule())
        .netModule(NetworkModule("http://randomfox.ca/"))
        .build()
        .inject(this)
}
package com.github.krllus.training.dagger

import com.github.krllus.training.ui.fox.FoxFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeFoxFragment(): FoxFragment
}
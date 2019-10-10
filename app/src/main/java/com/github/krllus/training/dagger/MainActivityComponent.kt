package com.github.krllus.training.dagger

import com.github.krllus.training.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentsBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}

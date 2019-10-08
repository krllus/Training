package com.github.krllus.training.dagger

import com.github.krllus.training.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivitySubComponent::class])
internal abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    internal abstract fun bindMainAndroidInjectorFactory(factory: MainActivitySubComponent.Factory): AndroidInjector.Factory<*>
}

@Subcomponent(modules = [])
interface MainActivitySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}

package com.github.krllus.training.dagger

import com.github.krllus.training.ui.fox.FoxFragment
import dagger.*
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Component(
    modules = [
        AndroidInjectionModule::class,
        FoxFoxModule::class]
)
interface FoxComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun foxFragment(fragment: FoxFragment): Builder

        fun foxModule(module: FoxModule): Builder

        fun netModule(module: NetworkModule): Builder

        fun build(): FoxComponent
    }

    fun inject(app: FoxFragment)
}

@Module(subcomponents = [FoxSubComponent::class])
abstract class FoxFoxModule {
    @Binds
    @IntoMap
    @ClassKey(FoxFragment::class)
    abstract fun bindFoxFragmentInjectorFactory(factory: FoxSubComponent.Factory): AndroidInjector.Factory<FoxFragment>
}

@Subcomponent(modules = [FoxModule::class, NetworkModule::class])
interface FoxSubComponent : AndroidInjector<FoxFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<FoxFragment>
}
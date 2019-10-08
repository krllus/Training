package com.github.krllus.training.dagger

import com.github.krllus.training.ui.fox.FoxFragment
import dagger.*
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Component(modules = [FoxModule::class, NetworkModule::class])
interface FoxComponent {

    fun inject(app: FoxFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun fragment(fragment: FoxFragment): Builder

        fun netModule(module: NetworkModule): Builder

        fun foxModule(module: FoxModule): Builder

        fun build(): FoxComponent
    }
}

//@Module(subcomponents = [FoxSubComponent::class])
//abstract class FoxFoxModule {
//    @Binds
//    @IntoMap
//    @ClassKey(FoxFragment::class)
//    abstract fun bindFoxFragmentInjectorFactory(factory: FoxSubComponent.Factory): AndroidInjector.Factory<*>
//
//}
//
//@Subcomponent(modules = [FoxModule::class, NetworkModule::class])
//interface FoxSubComponent : AndroidInjector<FoxFragment> {
//    @Subcomponent.Factory
//    interface Factory : AndroidInjector.Factory<FoxFragment>
//}
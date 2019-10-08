package com.github.krllus.training.dagger

import androidx.fragment.app.Fragment
import com.github.krllus.training.ui.fox.FoxFragment
import dagger.*
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Component(modules = [FoxFoxModule::class])
interface FoxComponent {

    fun inject(app: FoxFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun fragment(fragment : Fragment) : Builder
        //fun create(@BindsInstance fragment: FoxFragment): FoxComponent

//        fun netModule(module: NetworkModule): Builder
//
//        fun foxModule(module: FoxModule): Builder

        fun build(): FoxComponent
    }
}

@Module(subcomponents = [FoxSubComponent::class])
abstract class FoxFoxModule {
    @Binds
    @IntoMap
    @ClassKey(FoxFragment::class)
    abstract fun bindFoxFragmentInjectorFactory(factory: FoxSubComponent.Factory): AndroidInjector.Factory<*>

}

@Subcomponent(modules = [AppModule::class, FoxModule::class, NetworkModule::class])
interface FoxSubComponent : AndroidInjector<FoxFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<FoxFragment>
}
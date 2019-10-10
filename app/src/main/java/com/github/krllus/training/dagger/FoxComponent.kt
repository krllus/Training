package com.github.krllus.training.dagger

import androidx.fragment.app.Fragment
import com.github.krllus.training.ui.fox.FoxFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        FoxModule::class,
        NetworkModule::class]
)
interface FoxComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun fragment(fragment: Fragment): Builder

        fun build(): FoxComponent
    }

    fun inject(fragment: FoxFragment)
}
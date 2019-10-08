package com.github.krllus.training.dagger

import com.github.krllus.training.TrainingApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: TrainingApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: TrainingApplication)
}
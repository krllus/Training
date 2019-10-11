package com.github.krllus.training.dagger

import android.app.Application
import android.content.Context
import com.github.krllus.training.TrainingApplication
import com.github.krllus.training.data.AppDatabase
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient

@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        AppExecutorsModule::class
    ]
)
@GlobalScope
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(trainingApplication: TrainingApplication)

    fun context(): Context

    fun cache(): Cache

    fun gson(): Gson

    fun okHttpClient(): OkHttpClient

    fun appDatabase(): AppDatabase
}
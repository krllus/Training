package com.github.krllus.training.dagger

import android.content.Context
import androidx.fragment.app.Fragment
import com.github.krllus.training.data.AppDatabase
import com.github.krllus.training.ui.fox.FoxFragment
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient

@Component(
    dependencies = [AppComponent::class],
    modules = [FoxModule::class]
)
@ModuleScope
interface FoxComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun fragment(fragment: Fragment): Builder

        fun appComponent(component: AppComponent): Builder

        fun build(): FoxComponent
    }

    fun inject(fragment: FoxFragment)

    fun context(): Context

    fun cache(): Cache

    fun gson(): Gson

    fun okHttpClient(): OkHttpClient

    fun appDatabase(): AppDatabase
}
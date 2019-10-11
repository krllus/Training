package com.github.krllus.training.dagger

import com.github.krllus.training.AppExecutors
import dagger.Module
import dagger.Provides

@Module
class AppExecutorsModule {
    @Provides
    @GlobalScope
    fun provideAppExecutors(): AppExecutors = AppExecutors()
}
package com.github.krllus.training.dagger

import com.github.krllus.training.data.FoxDao
import com.github.krllus.training.data.FoxRepository
import com.github.krllus.training.domain.service.FoxWebService
import com.github.krllus.training.ui.fox.FoxFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class FoxModule {

    @Singleton
    @Provides
    fun provideFoxWebService(retrofit: Retrofit): FoxWebService {
        return retrofit.create(FoxWebService::class.java)
    }

    @Singleton
    @Provides
    fun provideFoxRepository(
        webService: FoxWebService,
        executor: Executor,
        foxDao: FoxDao
    ): FoxRepository {
        return FoxRepository(webService, executor, foxDao)
    }

    @Provides
    fun provideServerUrl(): String = "http://randomfox.ca/"

}
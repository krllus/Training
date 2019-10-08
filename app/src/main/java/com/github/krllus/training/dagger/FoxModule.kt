package com.github.krllus.training.dagger

import com.github.krllus.training.AppExecutors
import com.github.krllus.training.data.FoxDao
import com.github.krllus.training.data.FoxRepository
import com.github.krllus.training.domain.service.FoxWebService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
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
        appExecutors: AppExecutors,
        foxDao: FoxDao
    ): FoxRepository {
        return FoxRepository(webService, appExecutors, foxDao)
    }

    @Provides
    fun provideServerUrl(): String = "http://randomfox.ca/"

}
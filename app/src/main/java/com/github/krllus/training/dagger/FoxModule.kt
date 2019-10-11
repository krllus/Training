package com.github.krllus.training.dagger

import com.github.krllus.training.AppExecutors
import com.github.krllus.training.data.AppDatabase
import com.github.krllus.training.data.FoxDao
import com.github.krllus.training.data.FoxRepository
import com.github.krllus.training.domain.service.FoxWebService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class FoxModule {

    @Provides
    @ModuleScope
    fun provideFoxWebService(retrofit: Retrofit): FoxWebService {
        return retrofit.create(FoxWebService::class.java)
    }

    @Provides
    @ModuleScope
    fun provideFoxDao(db: AppDatabase): FoxDao {
        return db.foxDao()
    }

    @Provides
    @ModuleScope
    fun provideFoxRepository(
        webService: FoxWebService,
        appExecutors: AppExecutors,
        foxDao: FoxDao
    ): FoxRepository {
        return FoxRepository(webService, appExecutors, foxDao)
    }

    @Provides
    @ModuleScope
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("http://randomfox.ca/")
            .client(okHttpClient)
            .build()
    }
}
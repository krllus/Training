package com.github.krllus.training.dagger

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.github.krllus.training.AppExecutors
import com.github.krllus.training.data.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @GlobalScope
    fun provideContext(application: Application): Context = application

    @Provides
    @GlobalScope
    fun provideDb(context: Application): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "training.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
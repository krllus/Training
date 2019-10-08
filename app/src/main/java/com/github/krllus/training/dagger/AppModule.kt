package com.github.krllus.training.dagger

import android.app.Application
import androidx.room.Room
import com.github.krllus.training.AppExecutors
import com.github.krllus.training.data.AppDatabase
import com.github.krllus.training.data.FoxDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun providesApplication(application: Application): Application = application

    @Singleton
    @Provides
    fun provideDb(context: Application): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "training.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideFoxDao(db: AppDatabase): FoxDao {
        return db.foxDao()
    }

    @Singleton
    @Provides
    fun provideAppExecutors(): AppExecutors {
        return AppExecutors()
    }
}
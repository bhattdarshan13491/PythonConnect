package com.example.pythonconnect.di

import android.content.Context
import androidx.room.Room
import com.example.pythonconnect.data.local.AppDatabase
import com.example.pythonconnect.data.local.CustomerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "customer_db"
        ).build()

    @Provides
    fun provideCustomerDao(db: AppDatabase): CustomerDao = db.customerDao()
}

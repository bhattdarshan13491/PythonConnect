package com.example.pythonconnect.data.local

import androidx.room.Database
import androidx.room.RoomDatabase




@Database(
        entities = [CustomerEntity::class],
        version = 1,
    )

abstract class AppDatabase : RoomDatabase() {
        abstract fun customerDao(): CustomerDao
}

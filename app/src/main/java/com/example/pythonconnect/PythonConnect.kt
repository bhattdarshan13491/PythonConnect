package com.example.pythonconnect

import android.app.Application
import com.example.pythonconnect.data.repository.customer.CustomerSeeder
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class PythonConnect : Application() {
    @Inject lateinit var seeder: CustomerSeeder

    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.IO).launch {
            seeder.seedCustomersIfNeeded()
        }
    }
}
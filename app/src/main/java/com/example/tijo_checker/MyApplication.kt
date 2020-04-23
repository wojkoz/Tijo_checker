package com.example.tijo_checker

import android.app.Application
import com.example.core.koin.repositoryModule
import com.example.core.koin.retrofitModule
import com.example.core.koin.roomModule
import com.example.grades.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(retrofitModule, repositoryModule, viewModelModule, roomModule)
        }
    }
}
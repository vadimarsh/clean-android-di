package com.example.cleanexamplemvvm

import android.app.Application
import com.example.cleanexamplemvvm.di.data
import com.example.cleanexamplemvvm.di.domain
import com.example.cleanexamplemvvm.di.presentation
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(presentation, domain, data))
        }
    }
}

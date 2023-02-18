package com.example.omnitest

import android.app.Application
import com.example.omnitest.module.networkModule
import com.example.omnitest.module.viewModelModule
import org.koin.core.context.startKoin

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */
class OmniTestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                networkModule,
                viewModelModule
            )
        }
    }
}
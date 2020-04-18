package com.ryunen344.selection

import android.app.Application
import com.ryunen344.selection.api.apiModule
import com.ryunen344.selection.home.homeModule
import com.ryunen344.selection.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.LogcatTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            androidFileProperties()
            modules(apiModule, repositoryModule, homeModule)
        }

        Timber.plant(LogcatTree())
    }
}

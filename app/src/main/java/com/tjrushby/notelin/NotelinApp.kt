package com.tjrushby.notelin

import android.app.Application
import com.tjrushby.notelin.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber


class NotelinApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@NotelinApp)
            modules(appModules)
        }
    }
}

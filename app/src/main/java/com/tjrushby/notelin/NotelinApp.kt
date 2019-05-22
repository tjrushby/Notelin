package com.tjrushby.notelin

import android.app.Application
import timber.log.Timber


class NotelinApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

package com.subhajitrajak.assignmentopeninapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OpenInApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
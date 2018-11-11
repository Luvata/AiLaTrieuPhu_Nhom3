package com.group3.`is`.prm391.ailatrieuphu_nhom3.ui

import android.app.Application

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
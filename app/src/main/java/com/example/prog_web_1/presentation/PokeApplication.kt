package com.example.prog_web_1.presentation

import android.app.Application
import android.content.Context

class PokeApplication : Application() {
    companion object{
        var context: Context?=  null
    }
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}
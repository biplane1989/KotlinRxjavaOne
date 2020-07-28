package com.example.kotlinrxjavaone

import android.app.Application

import android.nfc.Tag

import android.util.Log

class MyApplication : Application() {

    private var TAG = "MainActivity"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "orange one")
    }
}
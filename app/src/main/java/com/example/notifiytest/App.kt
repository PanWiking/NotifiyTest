package com.example.notifiytest

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    public var CHANELL_ID:String = "exaple"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            var serviceChannel:NotificationChannel = NotificationChannel(
                CHANELL_ID,
                "EXAMPLE SERVICE CHANNEL",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            var manager:NotificationManager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}
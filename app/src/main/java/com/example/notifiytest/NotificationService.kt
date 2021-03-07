package com.example.notifiytest

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat


class NotificationService: Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var input: String? = intent?.getStringExtra("inputExtra")

        var notificationIntent:Intent = Intent(this, MainActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        var notification:Notification = NotificationCompat.Builder(this, App().CHANELL_ID)
            .setContentTitle("EXAMPLE TITLE SERVICE")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_baseline_apartment_24)
            .setContentIntent(pendingIntent)
            .build()
    //        return super.onStartCommand(intent, flags, startId)
        startForeground(1, notification)
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
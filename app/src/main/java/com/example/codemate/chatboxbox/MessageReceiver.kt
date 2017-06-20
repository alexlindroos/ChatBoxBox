package com.example.codemate.chatboxbox

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by Alex Lindroos on 20/06/2017.
 */

class MessageReceiver : FirebaseMessagingService() {

    private val REQUEST_CODE = 1
    private val NOTIFICATION_ID = 6578
    private var title : String? = null
    private var message : String? = null
    private var TAG : String? = "FIREBASEMESSAGE"


    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        Log.d(TAG,"From: " + remoteMessage?.from)
        Log.d(TAG,"Message body " + remoteMessage?.notification?.body)

         title = remoteMessage?.notification?.title
         message = remoteMessage?.notification?.body

        showNotification("HARDCODED TITLE", message!!)

    }

    private fun showNotification(title: String, msg: String){
        var intent = Intent(this, MainActivity::class.java)

        var pendingIntent = PendingIntent.getActivity(this,REQUEST_CODE,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        var notification = NotificationCompat.Builder(this)
                .setContentText(msg)
                .setContentTitle(title)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .build()

        var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)
    }
}
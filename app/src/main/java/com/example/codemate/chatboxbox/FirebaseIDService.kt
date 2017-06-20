package com.example.codemate.chatboxbox

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by Alex Lindroos on 20/06/2017.
 */
class FirebaseIDService: FirebaseInstanceIdService() {

    private var TAG:String = "FIREBASEIDSERVICE"

    override fun onTokenRefresh() {
        super.onTokenRefresh()
        var refreshToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG,"Refreshed token: " + refreshToken)
        sendRegistrationToServer(refreshToken!!)
    }

    private fun sendRegistrationToServer(token: String) {

    }

}
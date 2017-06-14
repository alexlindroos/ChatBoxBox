package com.example.codemate.chatboxbox

import android.app.Activity
import android.os.Bundle
import com.example.codemate.chatboxbox.models.ChatMessage
import com.firebase.ui.database.FirebaseListAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.message.*
import java.text.DateFormat

/**
 * Created by Alex Lindroos on 14/06/2017.
 */

class ChatActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        fab_send.setOnClickListener {

            var ref = FirebaseDatabase.getInstance().reference

            var msg = ChatMessage(edit_message.text.toString(), FirebaseAuth.getInstance().currentUser.toString())
            print(msg)

            ref.push().setValue(msg)

            edit_message.setText("")
        }

        showChatMessages()
    }

    fun showChatMessages() {

    }
}
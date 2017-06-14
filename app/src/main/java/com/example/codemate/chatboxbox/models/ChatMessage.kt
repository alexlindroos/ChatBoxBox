package com.example.codemate.chatboxbox.models

import java.util.*

/**
 * Created by Alex Lindroos on 14/06/2017.
 */

class ChatMessage {
    var messageText:String
    var messageUser:String
    var messageTime:Long = 0

    constructor(messageText:String, messageUser:String) {
        this.messageText = messageText
        this.messageUser = messageUser
        // Initialize to current time
        messageTime = Date().time
    }


}



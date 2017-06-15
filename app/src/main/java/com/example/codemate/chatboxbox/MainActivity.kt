package com.example.codemate.chatboxbox

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val SIGN_IN_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.visibility = View.GONE
        btn_logout.visibility = View.GONE

        btn_start.setOnClickListener {
            val intent = Intent (this, ChattingActivity::class.java)
            startActivity(intent)
        }

        btn_logout.setOnClickListener {
                AuthUI.getInstance().signOut(this)
                        .addOnCompleteListener {
                            Toast.makeText(this, "You have been signed out.", Toast.LENGTH_LONG).show()
                            finish()
                            btn_start.visibility = View.GONE
                            btn_logout.visibility = View.GONE
                        }
        }

        authenticateUser()
    }

    fun authenticateUser() {
        if(FirebaseAuth.getInstance().currentUser == null) {
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .build(), SIGN_IN_REQUEST_CODE
            )
        } else {
            Toast.makeText(this, "Welcome " + FirebaseAuth.getInstance()
                    .currentUser!!.displayName, Toast.LENGTH_LONG)
                    .show()
            btn_start.visibility = View.VISIBLE
            btn_logout.visibility = View.VISIBLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SIGN_IN_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Signed in succesfully!", Toast.LENGTH_LONG).show()
                btn_start.visibility = View.VISIBLE
                btn_logout.visibility = View.VISIBLE
            }

        } else {
            Toast.makeText(this, "We could not sign you in. Please try again later.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}

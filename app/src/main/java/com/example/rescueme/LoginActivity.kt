package com.example.rescueme

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.rescueme.utils.isValidEntry
import com.example.rescueme.utils.toast


class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

       val button_login=findViewById<Button>(R.id.button_login)
       val email=findViewById<EditText>(R.id.email)
       val password=findViewById<EditText>(R.id.password)
       button_login.setOnClickListener {
           if(!email.isValidEntry() || !password.isValidEntry()){
               toast("Email and password is empty!")
               return@setOnClickListener
           }
           val setintent = Intent(this, SettingActivity::class.java)
           startActivity(setintent);

            Log.e("This is CSIT224", "button is clicked!")
           Toast.makeText(this, "The button is clicked!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }




    }
}
package com.example.rescueme

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.rescueme.utils.isValidEntry
import com.example.rescueme.utils.toast
import com.example.rescueme.utils.txt


class RegisterActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val name = findViewById<EditText>(R.id.edit_name)
        val email = findViewById<EditText>(R.id.edit_email)
        val password = findViewById<EditText>(R.id.edit_pass)
        val registerBtn = findViewById<Button>(R.id.Register)

        registerBtn.setOnClickListener {
            if (!name.isValidEntry() || !email.isValidEntry() || !password.isValidEntry()) {
                toast("All fields are required!")
                return@setOnClickListener
            }

            // Save to SharedPreferences
            val sharedPref = getSharedPreferences("UserPref", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("user_name", name.txt())
                putString("user_email", email.txt())
                putString("user_password", password.txt())
                apply()
            }

            toast("Registered successfully!")
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}
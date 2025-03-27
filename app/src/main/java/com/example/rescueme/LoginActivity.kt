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

        val buttonLogin = findViewById<Button>(R.id.button_login)
        val buttonRegister = findViewById<Button>(R.id.button_register)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

        buttonLogin.setOnClickListener {
            val emailInput = email.text.toString().trim()
            val passwordInput = password.text.toString()

            if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                toast("Email and password cannot be empty.")
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                toast("Please enter a valid email address.")
                return@setOnClickListener
            }
            // All validations passed, go to ProfilePage
                val setIntent = Intent(this, ProfilePageActivity::class.java)
                startActivity(setIntent)
            Log.e("This is CSIT224", "Login button clicked!")
            toast("Login successful!")
        }

        buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

}
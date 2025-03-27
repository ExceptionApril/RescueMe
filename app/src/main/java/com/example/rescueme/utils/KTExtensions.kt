package com.example.rescueme.utils



import android.app.Activity
import android.widget.EditText
import android.widget.Toast



//fun EditText.txt(): String{
//    return this.text.toString()
//}
//
//fun EditText.isValidEntry(): Boolean {
//    return this.text.toString().isNullOrEmpty()
//}
fun EditText.txt(): String = this.text.toString().trim()

fun EditText.isValidEntry(): Boolean = this.txt().isNotEmpty()

fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}
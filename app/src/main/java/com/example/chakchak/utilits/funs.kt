package com.example.chakchak.utilits

import android.content.Context
import android.content.Intent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.chakchak.R

fun AppCompatActivity.replaceActivity(activity: AppCompatActivity){
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(
            R.id.dataContainer,
            fragment
        ).commit()
}

fun showToast(message: String){
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}

fun hideKeyboard() {
    val imm: InputMethodManager = APP_ACTIVITY.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(APP_ACTIVITY.window.decorView.windowToken, 0)
}
package com.example.registerlogin.activities

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class ProfileActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.registerlogin.R.layout.activity_profile)

        var radioGroup = findViewById<RadioGroup>(com.example.registerlogin.R.id.idRGgroup)
        var themeTV = findViewById<TextView>(com.example.registerlogin.R.id.idtvTheme)

        // on below line we are setting on check change method for our radio group.
        // on below line we are setting on check change method for our radio group.
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // on radio button check change
            when (checkedId) {
                com.example.registerlogin.R.id.idRBLight -> {
                    // on below line we are checking the radio button with id.
                    // on below line we are setting the text to text view as light mode.
                    themeTV.text = "Light Theme"
                    // on below line we are changing the theme to light mode.
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
                com.example.registerlogin.R.id.idRBDark -> {
                    // this method is called when dark radio button is selected
                    // on below line we are setting dark theme text to our text view.
                    themeTV.text = "Dark Theme"
                    // on below line we are changing the theme to dark mode.
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
        }
    }
    
}
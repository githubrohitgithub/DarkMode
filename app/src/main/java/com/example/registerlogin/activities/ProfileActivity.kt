package com.example.registerlogin.activities

import `in`.madapps.prefrences.EasyPreferences
import `in`.madapps.prefrences.EasyPreferences.get
import `in`.madapps.prefrences.EasyPreferences.set
import android.content.Context
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.example.registerlogin.DarkMode
import com.example.registerlogin.R

class ProfileActivity : AppCompatActivity() {

    lateinit var context: Context
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        context=this

        val prefs = EasyPreferences.defaultPrefs(context)

        val radioGroup   = findViewById<RadioGroup>(R.id.idRGgroup)
        val idRBDark =findViewById<RadioButton>(R.id.idRBDark)
        val idRBLight =findViewById<RadioButton>(R.id.idRBLight)
        val themeTV = findViewById<TextView>(R.id.idtvTheme)

        if(DarkMode.isDarkThemeEnabled(context)){

            themeTV.text="Dark Mode ON"
            idRBDark.isChecked=true

        }else{
            themeTV.text="Dark Mode ON"
            idRBLight.isChecked=true

        }


        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // on radio button check change
            when (checkedId) {
                R.id.idRBLight -> {

                    themeTV.text="Dark Mode OFF"
                    prefs["DarkMode"] = false
                    DarkMode.applyTheme(false)

                }
                R.id.idRBDark -> {


                    themeTV.text="Dark Mode ON"
                    prefs["DarkMode"] = true
                    DarkMode.applyTheme(true)


                }
            }
        }




        }


    
}
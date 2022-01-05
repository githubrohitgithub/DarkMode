package com.example.registerlogin.activities
import android.content.Context
import android.os.Bundle
import android.widget.TextView
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
        val switchCompat01   = findViewById<SwitchCompat>(R.id.switchCompat01)
        val themeTV = findViewById<TextView>(R.id.idtvTheme)
        if(DarkMode.getModePref(context)==true)  DarkMode.applyTheme(true,context)



        if(DarkMode.getModePref(context)==true){

            themeTV.text="Dark Mode ON"
            switchCompat01.isChecked=true

        }else{

            themeTV.text="Dark Mode OFF"
            switchCompat01.isChecked=false

        }



        switchCompat01.setOnCheckedChangeListener { buttonView, isChecked ->
           if (isChecked) {
                themeTV.text="Dark Mode ON"
                DarkMode.applyTheme(true,context)


            }
            else {

                themeTV.text="Dark Mode OFF"
                DarkMode.applyTheme(false,context)


            }

        }




        }





}
package com.example.registerlogin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.registerlogin.R
import com.example.registerlogin.api.RetroInstance
import com.example.registerlogin.model.RegisterResponse
import retrofit2.Call
import retrofit2.Response

class Registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        var etEmailRegister = findViewById<EditText>(R.id.editTextEmail)
        var etPasswordRegister = findViewById<EditText>(R.id.editTextPassword)
        var etNameRegister = findViewById<EditText>(R.id.editTextName)
        var btnSignUp = findViewById<Button>(R.id.buttonSignUp)
        var tvLogin = findViewById<TextView>(R.id.textViewLogin)

        tvLogin.setOnClickListener(){
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        btnSignUp.setOnClickListener(){
            val email = etEmailRegister.text.toString().trim()
            val password = etPasswordRegister.text.toString().trim()

            if(email.isEmpty()){
                etEmailRegister.error = "Email required"
                etEmailRegister.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                etPasswordRegister.error = "Password required"
                etPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            RetroInstance.instance.register(email, password)
                .enqueue(object :retrofit2.Callback<RegisterResponse>{
                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>) {
                        if (!response.body()?.token!!){
                            Log.d("TAG Token", "get the token......" + response.body()?.token)
                            val intent = Intent(applicationContext, ProfileActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                       Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                })

        }
    }
}
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
import com.example.registerlogin.model.ExampleJson2KtKotlin
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLogin = findViewById<Button>(R.id.buttonLogin)
        var etEmail = findViewById<EditText>(R.id.editTextEmail)
        var etPassword = findViewById<EditText>(R.id.editTextPassword)
        var tvRegister = findViewById<TextView>(R.id.textViewRegister)

        btnLogin.setOnClickListener(){
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if(email.isEmpty()){
                etEmail.error = "Email required"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                etPassword.error = "Password required"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            RetroInstance.instance.login(email, password)
                .enqueue(object  :retrofit2.Callback<ExampleJson2KtKotlin>{
                    override fun onResponse(
                        call: Call<ExampleJson2KtKotlin>,
                        response: Response<ExampleJson2KtKotlin>) {
                        if (!response.body()?.token!!) {
                            Log.d("TAG Token", "get the token......" + response.body()?.token)
                            val intent = Intent(applicationContext, ProfileActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }else{
                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()

                        }

                    }

                    override fun onFailure(call: Call<ExampleJson2KtKotlin>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }
                })
        }

        tvRegister.setOnClickListener(){
            val intent = Intent(applicationContext, Registration::class.java)
            startActivity(intent)
        }
    }
}
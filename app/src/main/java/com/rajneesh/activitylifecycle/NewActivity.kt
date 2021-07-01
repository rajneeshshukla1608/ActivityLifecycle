package com.rajneesh.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class NewActivity : AppCompatActivity(){

    lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        sharedPreference = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreference.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_new)

        if (isLoggedIn){
            val intent = Intent(this@NewActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        lateinit var etPassword: EditText
        lateinit var btnLogin: Button
        lateinit var txtForgotPassword: TextView
        lateinit var txtRegister: TextView

        title = "Login here - Welcome "
        val etMobileNumber: EditText = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        val validMobileNumber = "0123456789"
        val validPassword = arrayOf("tony", "steve", "bruce", "thor")

        btnLogin.setOnClickListener {

            val mobileNumber = etMobileNumber.text.toString()

            val password = etPassword.text.toString()


            var nameofavenger = "Avenger"
            
            val intent = Intent(this@NewActivity,MainActivity::class.java)
            //startActivity(intent)
            if((mobileNumber == validMobileNumber)){

                if (password == validPassword[0]){
                    nameofavenger = "Iron man"
                    savePreferences(nameofavenger)
                    startActivity(intent)
                } else if (password == validPassword[1]){

                    nameofavenger = "caption america"
                    savePreferences(nameofavenger)
                    startActivity(intent)

                } else if (password == validPassword[2]){

                    nameofavenger = "hulk"
                    savePreferences(nameofavenger)

                    startActivity(intent)

                } else if (password == validPassword[3]){

                    nameofavenger = "The avengers"
                    savePreferences(nameofavenger)
                    startActivity(intent)

                }
            } else {
                Toast.makeText(this@NewActivity, "Invalid Credentials" , Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreference.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreference.edit().putString("Title", title).apply()

    }
}

package com.funkymaster.hasbni.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.funkymaster.hasbni.R
import com.funkymaster.hasbni.utilities.Util

class RegistrationActivity : AppCompatActivity() {

    private lateinit var emailReg_field : EditText
    private lateinit var passwordReg_field : EditText
    private lateinit var registration_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide() //removing the title bar
        } catch (e: NullPointerException) {
        } //catch
        setContentView(R.layout.activity_registration)


        initialize_variables()
        onClickWorkings()
    }   //on create method


    fun initialize_variables(){
        emailReg_field = findViewById(R.id.emailReg_field)
        passwordReg_field = findViewById(R.id.passwordReg_field)
        registration_btn = findViewById(R.id.registration_btn)
    }   //initialize variables

    fun onClickWorkings(){
        registration_btn.setOnClickListener(View.OnClickListener {
            var email = emailReg_field.text.toString()
            var password = passwordReg_field.text.toString()
            if(email.equals("") || password.equals(""))
                Toast.makeText(this, "Both email & password are required!" , Toast.LENGTH_LONG).show()
            else{
                if(!Util.isEmailValid(email))
                    Toast.makeText(this, "Please enter a valid email!" , Toast.LENGTH_LONG).show()
                else{
                    //both email & password are correct proceed
                    startActivity(Intent(this, OTPActivity :: class.java))
                } //inner else
            }   //outer else
        })

    }   //on click

}   //registration class
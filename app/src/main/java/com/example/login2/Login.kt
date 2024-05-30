package com.example.login2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.login2.databinding.ActivityLoginBinding
import com.example.login2.databinding.Registration

class Login : AppCompatActivity(){

    companion object{
        public val USERNAME = "username"
        public val PW = "pw"
    }

    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){
            val intent = result.data
            binding.editTextLoginUsername.setText(intent?.getStringExtra(USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(PW))
        }
    }

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.login.setOnClickListener {
            val registrationIntent = Intent(this, Registration::class.java)
            val username = registrationIntent.putExtra(USERNAME, binding.username.text.toString())
            val pw = registrationIntent.putExtra(PW, binding.pw.text.toString())

            startRegistrationForResult.launch(registrationIntent)
        }


    }
}
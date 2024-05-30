package com.example.login2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login2.databinding.AvtivityRegistrationBining

class Registration : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(Login.USERNAME) ?: ""
        val pw = intent.getStringExtra(Login.PW) ?: ""

        binding.editTextRegistrationUsername.setText(username)
        binding.editTextPassword.setText(pw)

        binding.buttonRegistrationRegister.setOnClickListener {
            val pw = binding.pw.text.toString()
            val confirm = binding.conpw.text.toString()
            val username = binding.usernames.text.toString()
            val name = binding.email.text.toString()
            val email = binding.name.text.toString()

            if(RegistrationUtil.validatePassword(pw, confirm) &&
                RegistrationUtil.validateUsername(username) &&
                RegistrationUtil.validateName(name) &&
                RegistrationUtil.validateEmail(email)){
                val resultIntent = Intent().apply {
                    putExtra(
                        Login.USERNAME,
                        binding.usernames.text.toString())
                    putExtra(Login.PW,
                        binding.usernames.pw.toString())
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }

        }
    }
}

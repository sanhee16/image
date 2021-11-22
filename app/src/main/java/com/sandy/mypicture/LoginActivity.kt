package com.sandy.mypicture

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sandy.mypicture.databinding.ActivityLoginBinding

class LoginActivity  : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.activity = this@LoginActivity
        Log.v("TAG", "LoginActivity" )
    }

    fun onClickLogin() {
        Log.v("TAG", "onclickLogin" )
        Log.v("TAG", "id : ${binding.editId.text} , password : ${binding.editPassword.text}" )
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
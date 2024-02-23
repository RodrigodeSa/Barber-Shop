package com.rodrigocsa.barbershop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.rodrigocsa.barbershop.databinding.ActivityMainBinding
import com.rodrigocsa.barbershop.view.Home

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnLogin.setOnClickListener {
            val name = binding.etName.text.toString()
            val password = binding.etPassword.text.toString()

            when {
                name.isEmpty() -> message(it, "Insira seu nome!")
                password.isEmpty() -> message(it, "Insira sua senha!")
                password.length <= 5 -> message(it, "A senha precisa ter 6 ou mais caracteres!")
                else -> navigateToHome(name)
            }
        }
    }

    private fun message(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    private fun navigateToHome(name: String) {
        val intent = Intent(this, Home::class.java)
        intent.putExtra("name", name)
        startActivity(intent)
    }

}
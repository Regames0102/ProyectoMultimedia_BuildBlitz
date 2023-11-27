package com.example.buildblitz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigateButton = findViewById<Button>(R.id.Acceder)
        val editText = findViewById<EditText>(R.id.editText)

        navigateButton.setOnClickListener {
            val usuario: String = editText.text.toString()

            val intent = Intent(this@MainActivity, CreditActivity::class.java)
            intent.putExtra("USUARIO_KEY", usuario)

            startActivity(intent)
        }
    }
}
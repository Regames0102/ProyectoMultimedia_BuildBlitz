package com.example.buildblitz

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)
        val textView = findViewById<TextView>(R.id.resultTextView)
        val contactButton = findViewById<Button>(R.id.contactButton)

        val usuario: String? = intent.getStringExtra("USUARIO_KEY")

        // Muestra el texto del usuario en el TextView
        textView.text = "$usuario estás usando la versión 1 de BuildBlitz"

        // Configura el clic del botón de contacto
        contactButton.setOnClickListener {
            // Crea un Intent para enviar un correo electrónico
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data =
                Uri.parse("mailto:") // Solo aplicaciones de correo electrónico deberían manejar esto

            // Asunto del correo electrónico
            val asunto = "Consulta de la app BuildBlitz"
            intent.putExtra(Intent.EXTRA_SUBJECT, asunto)

            // Dirección de correo electrónico (puedes cambiarla a tu dirección)
            val correoDestino = "dbenpar1612@g.educaand.es"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(correoDestino))

            // Lanza el intent
            startActivity(intent)
        }
    }
}
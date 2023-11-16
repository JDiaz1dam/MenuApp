package com.example.menuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()

        initListeners()

    }

    private lateinit var btn1: AppCompatButton
    private lateinit var btn2: AppCompatButton
    private lateinit var btn3: AppCompatButton
    private lateinit var btn4: AppCompatButton
    private lateinit var btn5: AppCompatButton
    private lateinit var texto: TextView

    private var muestratexto: Boolean = true


    private fun initComponents() {
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        texto = findViewById(R.id.texto)
    }

    private fun initListeners() {
        btn1.setOnClickListener {
            otherActivity()
        }

        btn2.setOnClickListener {
            val toast = Toast.makeText(this, "Has Apretado el Botón 2", Toast.LENGTH_SHORT)
            toast.show()
        }

        btn3.setOnClickListener {
            Snackbar.make(btn3, "Has Apretado el Botón 3", Snackbar.LENGTH_SHORT)
                .show()
        }

        btn4.setOnClickListener {
            btn4close()
        }

        btn5.setOnClickListener {
            btn5Muestra()
        }
    }

    private fun otherActivity() {
        val intent = Intent(this, otherActivity::class.java)
        startActivity(intent)
    }

    private fun btn4close() {
        finishAffinity()
    }

    private fun btn5Muestra() {
        muestratexto = !muestratexto
        when {
            !muestratexto -> {
                texto.text = "Este es el texto del Botón 5"
            }

            muestratexto -> {
                texto.text = ""
            }
        }
    }
}

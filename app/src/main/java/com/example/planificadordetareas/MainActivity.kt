package com.example.planificadordetareas
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botoon = findViewById<Button>(R.id.boto)

        botoon.setOnClickListener {
            var intento = Intent(this, MainActivity2::class.java)
            startActivity(intento)

        }
    }
}
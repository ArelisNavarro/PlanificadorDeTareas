package com.example.planificadordetareas

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var manager=supportFragmentManager

        var preferences=getSharedPreferences("registrar_usuario", Context.MODE_PRIVATE)

        if(preferences.getBoolean("Estado_Inicio_Sesion",false)){

            var transacios=manager.beginTransaction()
            transacios.replace(R.id.fragmentContainerView,PlanificadorDiario())
            transacios.commit()
        }


    }
}
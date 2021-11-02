package com.example.planificadordetareas.activitys

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.planificadordetareas.fragments.PlanificadorDiario
import com.example.planificadordetareas.R

    class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(preferences.getBoolean("Estado_Inicio_Sesion",false)){

            var transacion=fragmentManager.beginTransaction()
            transacion.replace(R.id.fragmentContainerView, PlanificadorDiario())
            transacion.commit()
        }
    }
}
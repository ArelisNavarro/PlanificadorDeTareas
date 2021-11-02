package com.example.planificadordetareas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.planificadordetareas.R
import com.example.planificadordetareas.application.App
import com.example.planificadordetareas.utilidades.toast

class Registrarse : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_registrarse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        var crearUsuario= view.findViewById<EditText>(R.id.edtCrearUsuario)
        var crearContraseña= view.findViewById<EditText>(R.id.edtCrearContraseña)
        var confirmarRegistro= view.findViewById<Button>(R.id.btConfirmaRegistro)
        var preguntaSeguridad= view.findViewById<EditText>(R.id.edtPreguntaSeguridad)

        confirmarRegistro.setOnClickListener(){

            var textoUsuario=crearUsuario.text.toString()
            var textoContraseña=crearContraseña.text.toString()
            var textoPreguntaSeguridad=preguntaSeguridad.text.toString()

            db.execSQL("INSERT INTO Usuarios( usuario, contraseña, preguntaSeguridad ) VALUES ('$textoUsuario','$textoContraseña', '$textoPreguntaSeguridad' )")

            toast("Registro Existoso")
            crearUsuario.text.clear()
            crearContraseña.text.clear()
            preguntaSeguridad.text.clear()
        }

    }

}
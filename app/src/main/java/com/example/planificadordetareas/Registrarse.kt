package com.example.planificadordetareas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.planificadordetareas.application.App

class Registrarse : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_registrarse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var application = requireActivity().application as App
        var db= application.db


        var crearUsuario= view.findViewById<EditText>(R.id.edtCrearUsuario)
        var crearContraseña= view.findViewById<EditText>(R.id.edtCrearContraseña)
        var confirmarRegistro= view.findViewById<Button>(R.id.btConfirmaRegistro)
        var preguntaSeguridad= view.findViewById<EditText>(R.id.edtPreguntaSeguridad)

        confirmarRegistro.setOnClickListener(){

            var textoUsuario=crearUsuario.text.toString()
            var textoContraseña=crearContraseña.text.toString()
            var textoPreguntaSeguridad=preguntaSeguridad.text.toString()

            db.execSQL("INSERT INTO Usuarios( usuario, contraseña, preguntaSeguridad ) VALUES ('$textoUsuario','$textoContraseña', '$textoPreguntaSeguridad' )")

            Toast.makeText(context,"Registro Existoso",Toast.LENGTH_SHORT).show()

            crearUsuario.text.clear()
            crearContraseña.text.clear()
            preguntaSeguridad.text.clear()
        }

    }

}
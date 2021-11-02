package com.example.planificadordetareas.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.planificadordetareas.R
import com.example.planificadordetareas.application.App
import com.example.planificadordetareas.utilidades.toast

class IniciarSesion() : BaseFragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var usuario=view.findViewById<EditText>(R.id.edtUsuario)
        var contraseña=view.findViewById<EditText>(R.id.edtContraseña)
        var iniciarSecion=view.findViewById<Button>(R.id.btIniciarSesion)
        var registrarse=view.findViewById<Button>(R.id.btRedirigeRegristrarse)
        var recuperarContrasena=view.findViewById<TextView>(R.id.tvRecuperarContraseña)

       iniciarSecion.setOnClickListener(){

           var usuarioTexto=usuario.text.toString()
           var contraseñaTexto=contraseña.text.toString()

           var user=usuarioTexto
           var result =db.rawQuery("SELECT COUNT(*) AS cantidad FROM Usuarios WHERE usuario='$user'",null)

           result.moveToFirst()
           var catidadRegistor=result.getInt(0)

           if (catidadRegistor>0){

               var resultadoi=db.rawQuery("SELECT contraseña , id from Usuarios where usuario='$user'",null)
               resultadoi.moveToFirst()
               val Rcontraseña =resultadoi.getString(0)
               val rId = resultadoi.getInt(1)


               if (contraseñaTexto.equals(Rcontraseña)){

                   var transacion=manager?.beginTransaction()
                   transacion?.replace(R.id.fragmentContainerView, PlanificadorDiario())

                 var editar = preferences.edit()

                   editar?.putInt("usuario_activo",rId)
                   editar.commit()

                   transacion?.commit()

               } else toast("Usuario o contraseña incorrectos")

               preferences?.edit()?.putBoolean("Estado_Inicio_Sesion",true)?.commit()

           }else{toast("El usuario no existe; por favor Registrese")}
       }


        recuperarContrasena.setOnClickListener(){

            var transacion=manager?.beginTransaction()
            transacion?.replace(R.id.fcRegistrarse, RecuperarContrasena())
            transacion?.commit()
        }



        registrarse.setOnClickListener(){

            var transaccion=manager?.beginTransaction()
            transaccion?.replace(R.id.fcRegistrarse, Registrarse())
            transaccion?.commit()
            registrarse.visibility=View.GONE
        }

    }

}
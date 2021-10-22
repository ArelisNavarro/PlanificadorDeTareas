package com.example.planificadordetareas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.planificadordetareas.application.App


class IniciarSesion() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_iniciar_sesion, container, false) }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var application = requireActivity().application as App
        var db= application.db

        var manager=activity?.supportFragmentManager

        var preferences=context?.getSharedPreferences("registrar_usuario", Context.MODE_PRIVATE)


        var usuario=view.findViewById<EditText>(R.id.edtUsuario)
        var contraseña=view.findViewById<EditText>(R.id.edtContraseña)
        var iniciarSecion=view.findViewById<Button>(R.id.btIniciarSesion)
        var registrarse=view.findViewById<Button>(R.id.btRedirigeRegristrarse)

       iniciarSecion.setOnClickListener(){

           var usuarioTexto=usuario.text.toString()
           var contraseñaTexto=contraseña.text.toString()

           var usuarioGuardado=preferences?.getString("usuario","No existe")
           var contraseñaGuardada=preferences?.getString("contraseña","No existe")

           var user=usuarioTexto
           var result =db.rawQuery("SELECT COUNT(*) AS cantidad FROM Usuarios WHERE usuario='$user'",null)

           result.moveToFirst()
           var catidadRegistor=result.getInt(0)

           if (catidadRegistor>0){

               if (usuarioTexto==usuarioGuardado && contraseñaTexto==contraseñaGuardada){

                   var transacion=manager?.beginTransaction()
                   transacion?.replace(R.id.fragmentContainerView,PlanificadorDiario())
                   transacion?.commit()

               } else Toast.makeText(context,"Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()


               preferences?.edit()?.putBoolean("Estado_Inicio_Sesion",true)?.commit()

           }else{

               Toast.makeText(context,"El usuario no existe; por favor Registrese",Toast.LENGTH_SHORT).show()

           }


       }

        registrarse.setOnClickListener(){

            var transaccion=manager?.beginTransaction()
            transaccion?.replace(R.id.fcRegistrarse,Registrarse())
            transaccion?.commit()
            registrarse.visibility=View.GONE
        }


    }


}
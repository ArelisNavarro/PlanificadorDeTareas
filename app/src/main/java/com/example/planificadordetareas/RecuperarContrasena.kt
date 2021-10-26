package com.example.planificadordetareas

import android.appwidget.AppWidgetProvider
import android.database.sqlite.SQLiteDatabase
import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.planificadordetareas.application.App

class RecuperarContrasena : Fragment() {
     val db:SQLiteDatabase
        get() = (requireActivity().application as App).db

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recuperar_contrasena, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var confirmarUsuario= view.findViewById<EditText>(R.id.edtConfirmarUsuario)
        var confirmacionSeguridad= view.findViewById<EditText>(R.id.edtColorFavorito)
        var nuevaContraseña= view.findViewById<EditText>(R.id.edtNuevaContraseña)
        var enviar= view.findViewById<Button>(R.id.btEnviar)
        var cambiarContrasena= view.findViewById<Button>(R.id.btCambiarContraseña)


        enviar.setOnClickListener(){

            var textoUsuario=confirmarUsuario.text.toString()
            var textoSeguridad=confirmacionSeguridad.text.toString()
            var textoNuevaContrasena=nuevaContraseña.text.toString()


            var cursor=db.rawQuery("SELECT preguntaSeguridad FROM Usuarios WHERE usuario='${textoUsuario}' ",null)

            var tiene=cursor.moveToFirst()

            if (!tiene){
               Toast.makeText(requireContext(),"Usuario no registrado",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var color=cursor.getString(0)

            if(textoSeguridad.equals(color)){

                nuevaContraseña.visibility=View.VISIBLE
                enviar.visibility=View.GONE
                cambiarContrasena.visibility=View.VISIBLE

            } else Toast.makeText(requireContext(),"Error, Respuesta de seguridad incorrecta",Toast.LENGTH_SHORT).show()
        }

        cambiarContrasena.setOnClickListener(){

            var textoUsuario=confirmarUsuario.text.toString()
            var textoSeguridad=confirmacionSeguridad.text.toString()
            var textoNuevaContrasena=nuevaContraseña.text.toString()


            db.execSQL("UPDATE Usuarios SET contraseña= '${textoNuevaContrasena}' WHERE usuario='${textoUsuario}'")

            Toast.makeText(requireContext(),"Su contraseña fue restablecida con exito",Toast.LENGTH_SHORT).show()

            confirmarUsuario.text.clear()
            confirmacionSeguridad.text.clear()
            nuevaContraseña.text.clear()
        }

    }
}
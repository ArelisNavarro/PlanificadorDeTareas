package com.example.planificadordetareas.activitys

import android.content.ContentValues
import android.os.Bundle
import android.widget.*

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.planificadordetareas.adapters.Adapter
import com.example.planificadordetareas.R
import com.example.planificadordetareas.model.Tareas
import com.example.planificadordetareas.utilidades.toast
import com.example.planificadordetareas.utilidades.visible
import java.lang.Exception
import java.sql.SQLException

class ActivityListaDeTareas : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dias_de_la_semana)

        var diaActual = intent.extras?.getString("dia")
        var usuarioActivo = preferences.getInt("usuario_activo", -1)


        var adapter = Adapter()

        actualizarLista(diaActual, usuarioActivo, adapter)

        var dia = findViewById<TextView>(R.id.dia)
        var reciclador = findViewById<RecyclerView>(R.id.reciclador)
        var botonflotante = findViewById<Button>(R.id.abrirEdit)
        var botonAgregarTarea = findViewById<Button>(R.id.agregar)
        var agregarTarea = findViewById<EditText>(R.id.editTarea)
        var agregarDescripcion = findViewById<EditText>(R.id.descripcionEdit)

        dia.text = diaActual

        var manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        reciclador.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        reciclador.layoutManager = manager
        reciclador.adapter = adapter

        botonAgregarTarea.setOnClickListener {

            var textoAgregarTarea = agregarTarea.text.toString()
            var textoAgregarDescripcion = agregarDescripcion.text.toString()

            if ((textoAgregarTarea.isNullOrBlank() || textoAgregarDescripcion.isNullOrBlank()) || usuarioActivo == -1) {
                agregarTarea.error = "No puedes enviar en blanco"
                agregarDescripcion.error = "No puedes enviar en blanco"
                if (usuarioActivo == -1) toast("Usuario No Valido")

            } else {

                try {

                    db.execSQL("INSERT INTO Listatareas( dia,nombre, descripcion, idusuario, estadotarea ) VALUES ('$diaActual','$textoAgregarTarea','$textoAgregarDescripcion', '$usuarioActivo', 0 )")
                    actualizarLista(diaActual, usuarioActivo, adapter)

                } catch (e: Exception) {
                    toast("error: ${e.message}")

                }
            }
            agregarTarea.visible(false)
            agregarDescripcion.visible(false)
            botonAgregarTarea.visible(false)


            agregarTarea.text.clear()
            agregarDescripcion.text.clear()
        }

        botonflotante.setOnClickListener {
            agregarTarea.visible(true)
            agregarDescripcion.visible(true)
            botonAgregarTarea.visible(true)
        }


        adapter.cheked = { tarea->

                var content=ContentValues()
                content.put("estadotarea",tarea.estadotarea)
                var params= arrayOf(tarea.id.toString())
                var result=db.update("Listatareas",content,"id=?",params)

                if (result>0){
                    actualizarLista(diaActual,usuarioActivo,adapter)
                }else{ toast("No se pudo actuaizar")}
        }


        adapter.eliminar={ tarea->

                var params= arrayOf(tarea.id.toString())
               var result= db.delete("Listatareas","id=?",params)

                if (result>0){
                    actualizarLista(diaActual,usuarioActivo,adapter)
                }else{
                    toast("No se elimino nada")
                }

        }

    }

    private fun actualizarLista(
        eldia: String?,
        usuarioActivo: Int,
        objetoadaptador: Adapter
    ) {

        var lista=ArrayList<Tareas>()
        var cursor = db.rawQuery(
            "SELECT * FROM Listatareas WHERE dia='$eldia' AND idusuario = $usuarioActivo",
            null
        )

        if (cursor.moveToFirst()) {

            lista.add(
                Tareas(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(5)
                )
            )

        }

        while (cursor.moveToNext()) {
            lista.add(
                Tareas(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(5)
                )
            )
        }
        objetoadaptador.actualizarLista(lista)
    }
}
package com.example.planificadordetareas

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.*

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dias_de_la_semana)



        var tarea=findViewById<TextView>(R.id.tarea)
        var descripcion=findViewById<TextView>(R.id.descripcion01)
        var checkBox=findViewById<CheckBox>(R.id.check01)
       // var editDescripcion=findViewById<EditText>(R.id.descripcionEdit)
        //var editTarea=findViewById<EditText>(R.id.editTarea)
        var dia=findViewById<TextView>(R.id.dia)
        var basurero=findViewById<ImageView>(R.id.basurero)
        var pestañas=findViewById<ImageView>(R.id.pestaña)
        var reciclerdor = findViewById<RecyclerView>(R.id.reciclador)
        var botonflotante=findViewById<Button>(R.id.abrirEdit)




        var manager= LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        reciclerdor.layoutManager=manager



        reciclerdor.addItemDecoration(DividerItemDecoration(this, RecyclerView.HORIZONTAL))


        var objetoadaptador= Adapter()

        reciclerdor.adapter=objetoadaptador


        var listadeladaptador= objetoadaptador.lista


        var boton= findViewById<Button>(R.id.agregar)
        var agregar= findViewById<EditText>(R.id.editTarea)
        var textodeladescripciob= findViewById<EditText>(R.id.descripcionEdit)

        boton.setOnClickListener {

            var textosacado=agregar.text
            var textoDes=textodeladescripciob.text

            if (textosacado.isBlank() || textosacado.isEmpty()){
                agregar.error="No puedes enviAR EN BLANCO"

            }else{
                listadeladaptador.add(textosacado.toString())


                // objetoadaptador.notifyDataSetChanged()

                agregar.setText("")

            }
            if (textoDes.isBlank() || textoDes.isEmpty()){
                textodeladescripciob.error="No puedes enviAR EN BLANCO"

            }else{
                listadeladaptador.add(textoDes.toString())
                objetoadaptador.notifyDataSetChanged()

                textodeladescripciob.setText("")

            }
            agregar.visibility= View.GONE
            textodeladescripciob.visibility= View.GONE






        }

        botonflotante.setOnClickListener{
            agregar.visibility= View.VISIBLE
            textodeladescripciob.visibility= View.VISIBLE


        }










    }
}
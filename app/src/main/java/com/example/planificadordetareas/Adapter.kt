package com.example.planificadordetareas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<Adapter.ViewHold>() {


    var lista:ArrayList<String> = ArrayList(
    )



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHold (
        LayoutInflater.from(parent.context).inflate(R.layout.item_de_recicler,parent,false)
            )
    override fun onBindViewHolder(holder: ViewHold, position: Int) {

        var adaptacion=holder.itemView
        var tarea=adaptacion.findViewById<TextView>(R.id.tarea)
        var descripcion=adaptacion.findViewById<TextView>(R.id.descripcion01)
        var checkBox=adaptacion.findViewById<CheckBox>(R.id.check01)
        var editDescripcion=adaptacion.findViewById<EditText>(R.id.descripcionEdit)
        var editTarea=adaptacion.findViewById<EditText>(R.id.editTarea)
        var dia=adaptacion.findViewById<TextView>(R.id.dia)
        var basurero=adaptacion.findViewById<ImageView>(R.id.basurero)
        var pestañas=adaptacion.findViewById<ImageView>(R.id.pestaña)





    }

    override fun getItemCount(): Int {
        return lista.size

    }

    class ViewHold (itemView: View): RecyclerView.ViewHolder(itemView)
}

package com.example.planificadordetareas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.planificadordetareas.R
import com.example.planificadordetareas.model.Tareas

class Adapter: RecyclerView.Adapter<Adapter.ViewHold>() {


    private var lista= ArrayList<Tareas>()

    var cheked:(tarea:Tareas)->Unit ={_ ->  }
    var eliminar:(t: Tareas)-> Unit={ _-> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHold (
        LayoutInflater.from(parent.context).inflate(R.layout.item_de_recicler,parent,false)
            )
    override fun onBindViewHolder(holder: ViewHold, position: Int) {

        var t=lista.get(position)


        var v=holder.itemView
        var tarea=v.findViewById<TextView>(R.id.tarea)
        var descripcion=v.findViewById<TextView>(R.id.descripcion01)
        var estadotarea=v.findViewById<CheckBox>(R.id.checkboxestadotarea)
        var eliminar=v.findViewById<ImageView>(R.id.eliminar)

        tarea.text=t.tarea
        descripcion.text=t.descripcionTareas

        estadotarea.isChecked= t.estadotarea==1

        estadotarea.setOnClickListener {  view ->

            var isChequetInt= if ((view as CompoundButton ).isChecked) 1 else 0

            t.estadotarea= isChequetInt
            cheked(t)

            }

        eliminar.setOnClickListener{
            eliminar(t)
        }



    }



    override fun getItemCount(): Int {
        return lista.size

    }


    fun actualizarLista(lista:ArrayList<Tareas>){
        this.lista=lista
        notifyDataSetChanged()
    }




    class ViewHold (itemView: View): RecyclerView.ViewHolder(itemView)
}

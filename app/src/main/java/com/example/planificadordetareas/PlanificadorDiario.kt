package com.example.planificadordetareas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner


class PlanificadorDiario : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_planificador_diario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        var configuracion= view.findViewById<Spinner>(R.id.SpnOpciones)

        var array= arrayListOf<String>("Idioma Esp/Eng","Oscuro/claro","Cerrar sesión")

        var arrayAdapter=ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,array)
            configuracion.adapter=arrayAdapter


        var escuchadorSpiner= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {



            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }

    }


}
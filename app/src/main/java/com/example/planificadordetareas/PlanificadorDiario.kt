package com.example.planificadordetareas

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.core.view.children
import androidx.fragment.app.FragmentManager

class PlanificadorDiario : Fragment(), View.OnClickListener {


    val manager:FragmentManager
    get() = requireActivity().supportFragmentManager

    val preferences: SharedPreferences
    get()=requireContext().getSharedPreferences("registrar_usuario", Context.MODE_PRIVATE)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_planificador_diario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            setHasOptionsMenu(true)

        var diasSemanasContainer=view.findViewById<LinearLayout>(R.id.linearDiasSemana)

        diasSemanasContainer.children.iterator().forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_principal, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.menu_idioma->{ }
            R.id.menu_tema->{ }
            R.id.menu_cerrarSesion->{

                var transaccion=manager?.beginTransaction()
                transaccion?.replace(R.id.fragmentContainerView,IniciarSesion())
                transaccion?.commit()

                preferences?.edit()?.putBoolean("Estado_Inicio_Sesion",false)?.commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {

            val irAlDia=Intent(requireContext(),MainActivity2::class.java)
            var bundl=Bundle()
            bundl.putString("dia",(v as TextView).text.toString())
            startActivity(irAlDia,bundl)
    }
}



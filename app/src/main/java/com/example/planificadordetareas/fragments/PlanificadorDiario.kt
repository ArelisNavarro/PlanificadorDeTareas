package com.example.planificadordetareas.fragments

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.view.children
import com.example.planificadordetareas.R
import com.example.planificadordetareas.activitys.ActivityListaDeTareas

class PlanificadorDiario : BaseFragment(), View.OnClickListener {




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

            R.id.menu_desmarcartodo ->{

            }
            R.id.menu_tema ->{ }
            R.id.menu_cerrarSesion ->{

                var transaccion=manager?.beginTransaction()
                transaccion?.replace(R.id.fragmentContainerView, IniciarSesion())
                transaccion?.commit()

                preferences?.edit()?.putBoolean("Estado_Inicio_Sesion",false)?.commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {

            val irAlDia=Intent(requireContext(), ActivityListaDeTareas::class.java)

                irAlDia.putExtra("dia",(v as TextView).text.toString())
            startActivity(irAlDia)
    }
}



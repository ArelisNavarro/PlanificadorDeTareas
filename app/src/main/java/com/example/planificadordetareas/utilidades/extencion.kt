package com.example.planificadordetareas.utilidades

import android.database.sqlite.SQLiteDatabase
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.planificadordetareas.model.Tareas


fun AppCompatActivity.toast(mensage:String){
    Toast.makeText(this,mensage,Toast.LENGTH_SHORT).show()
}


fun View.visible(visible:Boolean){
    visibility= if (visible) View.VISIBLE else View.GONE
}

fun Fragment.toast(mensage: String){
    Toast.makeText(requireContext(),mensage,Toast.LENGTH_SHORT).show()
}


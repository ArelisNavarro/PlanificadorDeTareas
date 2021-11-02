package com.example.planificadordetareas.activitys

import android.content.Context
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.planificadordetareas.application.App

open class BaseActivity:AppCompatActivity(){


    lateinit var db: SQLiteDatabase

    lateinit var preferences:SharedPreferences

    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db= (application as App).db
        preferences=getSharedPreferences("usuario_abierto", Context.MODE_PRIVATE)
        fragmentManager=supportFragmentManager
    }

}
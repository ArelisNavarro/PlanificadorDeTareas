package com.example.planificadordetareas.fragments

import android.content.Context
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.planificadordetareas.application.App

open class BaseFragment: Fragment() {

    lateinit var preferences: SharedPreferences
    lateinit var manager:FragmentManager

    lateinit var db:SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences=requireContext().getSharedPreferences("usuario_abierto", Context.MODE_PRIVATE)
        manager=requireActivity().supportFragmentManager
        db=(requireActivity().application as App).db


    }


}
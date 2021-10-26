package com.example.planificadordetareas

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Dbhelper(contex: Context?,name:String, cursor: SQLiteDatabase.CursorFactory?, version:Int): SQLiteOpenHelper(
    contex, name, cursor, version) {


    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE IF NOT EXISTS Usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT UNIQUE, contraseña TEXT, preguntaSeguridad TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}
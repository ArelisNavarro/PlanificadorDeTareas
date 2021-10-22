package com.example.planificadordetareas.application

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import com.example.planificadordetareas.Dbhelper

class App: Application() {


    lateinit var db:SQLiteDatabase


    override fun onCreate() {
        super.onCreate()

        var dbhelper= Dbhelper(this,"LosUsuarios",null,1)
        db=dbhelper.writableDatabase
    }

    override fun onTerminate() {
        super.onTerminate()
        db.close()
    }

}
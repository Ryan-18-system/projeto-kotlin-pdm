package br.edu.ifpb.peladainimigosdabola.banco

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper(var context: Context): SQLiteOpenHelper(context, "pelada.db", null, 1)   {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table duelo(id integer primary key autoincrement, selecao text, local text, resultado integer, data integer)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, anterior: Int, atual: Int) {

    }
}
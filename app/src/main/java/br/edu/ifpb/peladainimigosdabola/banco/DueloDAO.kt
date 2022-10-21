package br.edu.ifpb.peladainimigosdabola.banco

import android.content.ContentValues
import android.content.Context
import br.edu.ifpb.peladainimigosdabola.model.Duelo

class DueloDAO {
    val banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(duelo: Duelo){
        val cv = ContentValues()
        cv.put("selecao", duelo.selecao )
        cv.put("local", duelo.local)
        cv.put("resultado", duelo.resultado )
        cv.put("data", duelo.data)
        this.banco.writableDatabase.insert("duelo", null, cv)
    }

    fun read(): ArrayList<Duelo>{
        val lista = arrayListOf<Duelo>()
        val colunas = arrayOf("id", "selecao", "local", "resultado", "data")
        val c = this.banco.readableDatabase.query("duelo", colunas, null, null, null, null, null)
        c.moveToFirst()
        for (i in 1 .. c.count){
            val id = c.getInt(0)
            val selecao = c.getString(1)
            val local = c.getString(2)
            val resultado = c.getInt(3)
            val data = c.getLong(4)
            val duelo = Duelo(id, selecao, local,resultado,data)
            lista.add(duelo)
            c.moveToNext()
        }
        return lista
    }

    fun find(id: Int): Duelo?{
        val colunas = arrayOf("id","selecao","local","resultado","data")
        val where = "id = ?"
        val parametroWhere = arrayOf(id.toString())
        val c = this.banco.readableDatabase.query("duelo",colunas,where,parametroWhere,null,null,null)
        c.moveToFirst()
        if(c.count == 1){
            val id = c.getInt(0)
            val selecao = c.getString(1)
            val local = c.getString(2)
            val resultado = c.getInt(3)
            val data = c.getLong(4)
            val duelo = Duelo(id, selecao, local,resultado,data)
            return duelo
        }
        return null
    }

    fun delete(id: Int){
        val where = arrayOf(id.toString())
        this.banco.writableDatabase.delete("duelo", "id = ?", where)
    }



    fun update(pessoa: Duelo){

    }
}
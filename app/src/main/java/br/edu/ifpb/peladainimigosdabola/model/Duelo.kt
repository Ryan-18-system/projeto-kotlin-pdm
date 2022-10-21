package br.edu.ifpb.peladainimigosdabola.model

import android.util.Log
import java.io.Serializable
import java.util.*

class Duelo: Serializable {
    val id: Int
    val selecao: String
    val local: String
    val resultado: Int
    val data: Long
    constructor(selecao:String, local:String, resultado: Int){
        this.id = -1
        this.selecao = selecao
        this.local = local
        this.resultado = resultado
        this.data = Calendar.getInstance().timeInMillis

    }

    constructor(id:Int,selecao:String, local:String, resultado: Int, data: Long){
        this.id = id
        this.selecao = selecao
        this.local = local
        this.resultado = resultado
        this.data = data
    }

    override fun toString(): String {
        val dataFormatada = Calendar.getInstance()
        dataFormatada.timeInMillis = this.data.toLong()
        val dia = dataFormatada.get(Calendar.DAY_OF_MONTH)
        val mes = dataFormatada.get(Calendar.MONTH)+1
        val ano = dataFormatada.get(Calendar.YEAR)
        if(this.resultado == -1){
            return "${selecao.uppercase()} | $local | Derrota | $dia/$mes/$ano"
        }else if(this.resultado ==1){
            return "${selecao.uppercase()} | $local | Vitória |$dia/$mes/$ano "
        }else{
            return "${selecao.uppercase()} | $local | Empate | $dia/$mes/$ano"
        }

    }

}
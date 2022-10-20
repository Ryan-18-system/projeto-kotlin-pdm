package br.edu.ifpb.peladainimigosdabola.model

import java.io.Serializable
import java.util.*

class Duelo: Serializable {
    val id: Int
    val selecao: String
    val local: String
    val resultado: Int
    val data: Int
    constructor(selecao:String, local:String, resultado: Int){
        this.id = -1
        this.selecao = selecao
        this.local = local
        this.resultado = resultado
        this.data = Calendar.getInstance().timeInMillis.toInt()
    }
    constructor(id:Int,selecao:String, local:String, resultado: Int){
        this.id = id
        this.selecao = selecao
        this.local = local
        this.resultado = resultado
        this.data = Calendar.getInstance().timeInMillis.toInt()
    }
    constructor(id:Int,selecao:String, local:String, resultado: Int, data: Int){
        this.id = id
        this.selecao = selecao
        this.local = local
        this.resultado = resultado
        this.data = Calendar.getInstance().timeInMillis.toInt()
    }

    override fun toString(): String {
        if(this.resultado == -1){
            return "${selecao.uppercase()} | $local | Derrota"
        }else if(this.resultado ==1){
            return "${selecao.uppercase()} | $local | Vitória"
        }else{
            return "${selecao.uppercase()} | $local | Empate"
        }

    }

}
package br.edu.ifpb.peladainimigosdabola

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import br.edu.ifpb.peladainimigosdabola.model.Duelo

class DueloAdapter(var context: Context, var lista: ArrayList<Duelo>): BaseAdapter()  {
    override fun getCount(): Int = this.lista.size

    override fun getItem(index: Int): Any {
        return this.lista.get(index)
    }

    override fun getItemId(id: Int): Long {
        return id.toLong()
    }

    override fun getView(index: Int, view: View?, viewGroup: ViewGroup?): View {
        val viewLocal = if (view == null){
            LayoutInflater.from(this.context).inflate(R.layout.duelos_layout, viewGroup, false)
        }else{
            view
        }

        val duelo = this.lista[index]
        val tvDuelo: TextView = viewLocal.findViewById(R.id.tvItemDuelo)

        tvDuelo.text = duelo.toString()

        if (duelo.resultado == 1){
            viewLocal.setBackgroundColor(Color.GREEN)
        }else if(duelo.resultado == -1){
            viewLocal.setBackgroundColor(Color.RED)
        }else{
            viewLocal.setBackgroundColor(Color.GRAY)
        }

        return viewLocal
    }
}
package br.edu.ifpb.peladainimigosdabola

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import br.edu.ifpb.peladainimigosdabola.banco.DueloDAO
import br.edu.ifpb.peladainimigosdabola.model.Duelo
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btAdd: FloatingActionButton
    private  lateinit var lvMainDuelos : ListView
    private lateinit var daoDueloDAO: DueloDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.lvMainDuelos = findViewById(R.id.lvMainDuelos)
        this.daoDueloDAO = DueloDAO(this)
        this.btAdd = findViewById(R.id.fabMainAdd)
        this.btAdd.setOnClickListener(OnClickAdd())

        this.lvMainDuelos.onItemLongClickListener = OnItemLongClick()
    }
    private fun atualizar(){

        this.lvMainDuelos.adapter = DueloAdapter(this,this.daoDueloDAO.read())
    }
    inner class OnClickAdd: View.OnClickListener{
        override fun onClick(p0: View?) {
            val intent = Intent(this@MainActivity,FormActivity::class.java)
            if (intent.resolveActivity(packageManager) != null) startActivity(intent)
        }
    }
    inner class OnItemLongClick: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(adapter: AdapterView<*>?, view: View?, index: Int, id: Long): Boolean {
            val duelo = adapter?.getItemAtPosition(index) as Duelo
            this@MainActivity.daoDueloDAO.delete(duelo.id)
            val msg = "${duelo.selecao} removido com sucesso!"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            this@MainActivity.atualizar()
            return true
        }
    }
    override fun onResume() {
        super.onResume()
        this.atualizar()
    }
}
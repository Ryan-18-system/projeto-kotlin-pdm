package br.edu.ifpb.peladainimigosdabola

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import br.edu.ifpb.peladainimigosdabola.banco.DueloDAO
import br.edu.ifpb.peladainimigosdabola.model.Duelo
import java.lang.Exception

class FormActivity : AppCompatActivity() {
    private lateinit var etFormSelecao: EditText
    private lateinit var etFormLocal: EditText
    private  lateinit var radioButtonVitoria: RadioButton
    private  lateinit var  radioButtonDerrota: RadioButton
    private lateinit var radioButtonEmpate: RadioButton
    private lateinit var btFormSalvar : Button
    private  lateinit var btFormCancelar: Button
    private lateinit var daoDuelo: DueloDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        this.daoDuelo = DueloDAO(this)

        this.etFormSelecao = findViewById(R.id.etFormSelecao)
        this.etFormLocal = findViewById(R.id.etFormLocal)
        this.radioButtonVitoria = findViewById(R.id.radioButtonVitoria)
        this.radioButtonDerrota = findViewById(R.id.radioButtonDerrota)
        this.radioButtonEmpate = findViewById(R.id.radioButtonEmpate)
        this.btFormCancelar = findViewById(R.id.btFormCancelar)
        this.btFormSalvar = findViewById(R.id.btFormSalvar)

        this.btFormSalvar.setOnClickListener(OnAddDuelo())

    }
    inner class OnAddDuelo:View.OnClickListener{

        override fun onClick(p0: View?) {
            try{
                val selecao = this@FormActivity.etFormSelecao.text.toString()
                val local = this@FormActivity.etFormLocal.text.toString()
                var resultado:Int = if(this@FormActivity.radioButtonEmpate.isChecked){
                    0
                }else if(this@FormActivity.radioButtonVitoria.isChecked){
                    1
                }else{
                    -1
                }
                val newDuelo = Duelo(selecao,local,resultado)
                this@FormActivity.daoDuelo.insert(newDuelo)
                finish()
            }catch (e:Exception){
                Toast.makeText(this@FormActivity,"${e.message}",Toast.LENGTH_LONG).show()
            }
        }
    }

}
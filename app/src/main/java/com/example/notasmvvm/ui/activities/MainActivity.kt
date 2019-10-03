package com.example.notasmvvm.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.notasmvvm.R
import com.example.notasmvvm.data.Nota
import com.example.notasmvvm.ui.adapters.NotasAdapter
import com.example.notasmvvm.viewmodels.NotasViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialogo_ui.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var notasViewModel: NotasViewModel

    //essa variável só será inicializada quando for chamada
    private val notasAdapter: NotasAdapter by lazy {
        NotasAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar_pers)

        recycler_view.adapter = notasAdapter

        //inicializa o ViewModel
        notasViewModel = ViewModelProviders.of(this).get(NotasViewModel::class.java)

        notasViewModel.getNotas().observe(this, Observer {data ->
            //verificar se a lista é nula
            data?.let {
                if(it.isEmpty()){
                    Toast.makeText(this,"Lista vazia", Toast.LENGTH_LONG).show()
                } else {
                    Log.d("NOTA",it.toString())
                    notasAdapter.add(it)
                }
            }
        })
    }

    //adição do menu principal
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == R.id.action_bar_adicionar){
            dialogoAddNota()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialogoAddNota(){
        //transforma o dialogo_ui em view
        val layout = LayoutInflater.from(this)
            .inflate(R.layout.dialogo_ui,null, false)

        val textoNota = layout.input_nota

        val dialog = AlertDialog.Builder(this)
        dialog.setView(layout)
        dialog.setNegativeButton("Cancelar", null)
        dialog.setPositiveButton("Salvar"){d, i ->
            //Salvar a nota
            val nota = Nota(0, textoNota.text.toString())
            notasViewModel.salvar(nota)
        }
        dialog.create().show()

    }
}

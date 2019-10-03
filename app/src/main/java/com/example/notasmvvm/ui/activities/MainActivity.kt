package com.example.notasmvvm.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.notasmvvm.R
import com.example.notasmvvm.ui.adapters.NotasAdapter
import com.example.notasmvvm.viewmodels.NotasViewModel
import kotlinx.android.synthetic.main.activity_main.*

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
//        recycler_view.layoutManager = LinearLayoutManager(this)

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
                    Toast.makeText(this,"Lista carregada"+notasAdapter, Toast.LENGTH_SHORT).show()
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
            TODO("Chamar tela para adicionar nota")
        }
        return super.onOptionsItemSelected(item)
    }
}

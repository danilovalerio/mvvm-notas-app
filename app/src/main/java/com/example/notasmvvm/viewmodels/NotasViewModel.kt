package com.example.notasmvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notasmvvm.data.GestorDeNotas
import com.example.notasmvvm.data.Nota

/**
 * Essa classe será a gestora das notas, e pode ser utilizada por qualquer view
 */

class NotasViewModel: ViewModel() {
    //consumir os dados da model / data
    private val gestorNotas = GestorDeNotas()
    private val mNotas = MutableLiveData<List<Nota>>()

    //retorna as notas
    fun getNotas():MutableLiveData<List<Nota>> = mNotas

    fun carregarNotas(){
        val tmp = gestorNotas.getNotas()
        mNotas.postValue(tmp)
    }
}
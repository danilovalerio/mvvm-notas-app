package com.example.notasmvvm.viewmodels

import android.util.Log
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
    private var mNotas: MutableLiveData<List<Nota>>? = null

    //retorna as notas
    fun getNotas():MutableLiveData<List<Nota>> {
        if (mNotas == null){
            mNotas = MutableLiveData()
            val tmp = gestorNotas.getNotas()
            mNotas!!.postValue(tmp)
        }
        return mNotas!!
    }

    //salvar as notas
    fun salvar(mNota: Nota){
        gestorNotas.addNota(mNota)
    }
}
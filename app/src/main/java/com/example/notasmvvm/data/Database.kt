package com.example.notasmvvm.data

import androidx.lifecycle.MutableLiveData

class Database {

    private val mDatabase: MutableLiveData<MutableList<Nota>> = MutableLiveData()

    fun inserirNota(nota: Nota){
        var tmp = mDatabase.value
        if(tmp == null){
            tmp = mutableListOf()
            tmp.add(nota)
        } else {
            tmp?.add(nota)
        }
        mDatabase.postValue(tmp)
    }

    //Retorna somente o valor da lista de dados
    fun obterNotas() = mDatabase
}
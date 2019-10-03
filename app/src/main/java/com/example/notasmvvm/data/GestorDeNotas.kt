package com.example.notasmvvm.data

import android.util.Log
import androidx.lifecycle.MutableLiveData

//Pega as notas do banco, do firebase etc...
class GestorDeNotas {

    private val data: MutableLiveData<MutableList<Nota>> = MutableLiveData()

//    private val data = mutableListOf<Nota>(
//        Nota(1,"Nota 1"),
//        Nota(2,"Nota 2"),
//        Nota(3,"Nota 3"),
//        Nota(4,"Nota 4"),
//        Nota(5,"Nota 5"),
//        Nota(6,"Nota 6"),
//        Nota(7,"Nota 7"),
//        Nota(8,"Nota 8"),
//        Nota(9,"Nota 9"),
//        Nota(10,"Nota10")
//    )

    fun getNotas() = data

    fun addNota(mNota: Nota){
        var tmp = data.value
        if(tmp == null){
            tmp = mutableListOf()
            tmp.add(mNota)
        } else {
            tmp?.add(mNota)
        }
        data.postValue(tmp)
    }

}
package com.example.notasmvvm.data

//Pega as notas do banco, do firebase etc... 
class GestorDeNotas {

    private val data = criaNotas()

    fun getNotas() = data


    fun criaNotas() : List<Nota> {
        lateinit var  notas: MutableList<Nota>

        for(i in 1..20){
            notas.add(Nota(i,"nota"+i))
        }

        return notas

    }



}
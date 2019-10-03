package com.example.notasmvvm.data

/**
 * Pega as notas do banco, do firebase etc...
 * Possui a responsabilidade somente de gerenciar os dados
 */

class GestorDeNotas {

    //Dependência para gestorDeNotas
    private val database = Database()

    fun getNotas() = database.obterNotas()

    fun addNota(mNota: Nota){
        database.inserirNota(mNota)
    }

}
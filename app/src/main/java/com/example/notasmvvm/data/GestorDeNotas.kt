package com.example.notasmvvm.data

//Pega as notas do banco, do firebase etc...
class GestorDeNotas {

    private val data = listOf<Nota>(
        Nota(1,"Nota 1"),
        Nota(2,"Nota 2"),
        Nota(3,"Nota 3"),
        Nota(4,"Nota 4"),
        Nota(5,"Nota 5"),
        Nota(6,"Nota 6"),
        Nota(7,"Nota 7"),
        Nota(8,"Nota 8"),
        Nota(9,"Nota 9"),
        Nota(10,"Nota10")
    )

    fun getNotas() = data


}
package com.example.notasmvvm.di

import com.example.notasmvvm.data.Database
import org.koin.dsl.module.module

/**
 * Módulos de dependências via DSL
 */

object ModulosDeDependencias {
    //um dos módulos que pode conter na aplicação
    val moduloDaApp = module {
        single { Database() }
    }
}
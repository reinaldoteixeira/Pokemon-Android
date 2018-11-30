package com.example.reinaldo.pokemon

import java.io.Serializable

data class Pokemon(var id: Long,
                   var nome: String,
                   val tipo: String? = null,
                   val descricao: String? = null ) : Serializable

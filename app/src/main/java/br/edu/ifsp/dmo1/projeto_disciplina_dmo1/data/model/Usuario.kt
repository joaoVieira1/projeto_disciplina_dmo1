package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey
    val email: String,

//    @ColumnInfo(name = "senha")
    val senha: String,

//    @ColumnInfo(name = "tipoUsuario")
    val tipoUsuario: String

)
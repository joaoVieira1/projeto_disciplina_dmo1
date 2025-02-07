package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "modalidades")
data class Modalidade(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

//    @ColumnInfo(name = "nome")
    val nome: String
)
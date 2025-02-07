package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "treinos",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["email"],
            childColumns = ["professor_email"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Modalidade::class,
            parentColumns = ["id"],
            childColumns = ["modalidade_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Treino(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val professor_email: String,

    val modalidade_id: Int,

    val rotina_alimentacao: String,

    val rotina_atividades: String
)
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
        )
    ]
)
data class Treino(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val professor_email: String,

    val modalidade: String,

    val rotina_alimentacao: String,

    val rotina_atividades: String
) {
    constructor(professor_email: String, modalidade: String, rotina_alimentacao: String, rotina_atividades: String) :
            this(0, professor_email, modalidade, rotina_alimentacao, rotina_atividades)
    override fun toString(): String {
        return "\n" +
                "Exercicio $id \n\n" +
                "${modalidade.uppercase()}\n" +
                "dieta: $rotina_alimentacao \n\n" +
                "rotina de treinos: $rotina_atividades \n" +
                "contato prof: $professor_email" +
                "\n "
    }
}
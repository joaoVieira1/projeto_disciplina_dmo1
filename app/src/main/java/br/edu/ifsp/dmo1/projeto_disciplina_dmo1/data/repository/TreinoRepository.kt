package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository

import android.content.Context
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.database.AppDatabase
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino

class TreinoRepository(context: Context) {

    private val database = AppDatabase.getDatabase(context)
    private val dao = database.treinoDao()

    suspend fun getAll(): List<Treino>{
        return dao.getAllTreinos()
    }

    suspend fun insert(treino: Treino): Boolean {
        return dao.insert(treino) > 0
    }

    suspend fun getTreinosByModalidadeId(modalidade: String): List<Treino> {
        return dao.getTreinosByModalidadeId(modalidade)
    }

}
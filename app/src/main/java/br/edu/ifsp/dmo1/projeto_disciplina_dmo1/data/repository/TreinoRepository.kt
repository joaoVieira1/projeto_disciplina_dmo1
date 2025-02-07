package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository

import androidx.lifecycle.LiveData
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao.TreinoDao
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino

class TreinoRepository(private val treinoDao: TreinoDao) {

//    val allTreinos: LiveData<List<Treino>> = treinoDao.getAllTreinos()

    suspend fun insert(treino: Treino) {
        treinoDao.insert(treino)
    }

    suspend fun getTreinosByProfessorEmail(professorEmail: String): LiveData<List<Treino>> {
        return treinoDao.getTreinosByProfessorEmail(professorEmail)
    }

    suspend fun getTreinosByModalidadeId(modalidadeId: Int): LiveData<List<Treino>> {
        return treinoDao.getTreinosByModalidadeId(modalidadeId)
    }
}
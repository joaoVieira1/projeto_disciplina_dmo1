package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.TreinoRepository

class TreinoViewModel (private val repository: TreinoRepository) : ViewModel() {

    suspend fun insert(treino: Treino) {
        repository.insert(treino)
    }

    suspend fun getTreinosByProfessorEmail(professorEmail: String): List<Treino> {
        return repository.getTreinosByProfessorEmail(professorEmail)
    }

    suspend fun getTreinosByModalidadeId(modalidadeId: Int): List<Treino> {
        return repository.getTreinosByModalidadeId(modalidadeId)
    }
}
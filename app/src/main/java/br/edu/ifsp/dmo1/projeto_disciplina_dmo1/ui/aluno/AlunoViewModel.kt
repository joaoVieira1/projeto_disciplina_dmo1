package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.aluno

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.TreinoRepository

class AlunoViewModel(application: Application): AndroidViewModel(application)  {

    private val repository = TreinoRepository(application)

    suspend fun getAll(): List<Treino> {
        return repository.getAll()
    }


    suspend fun getAllByModalidade(modalidade: String): List<Treino> {
        return repository.getTreinosByModalidadeId(modalidade)
    }
}
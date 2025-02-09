package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.professor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.TreinoRepository
import kotlinx.coroutines.launch

class ProfessorViewModel(application: Application): AndroidViewModel(application)  {

    private val repository = TreinoRepository(application)


    fun insert(treino: Treino) = viewModelScope.launch {
        repository.insert(treino)
    }



}
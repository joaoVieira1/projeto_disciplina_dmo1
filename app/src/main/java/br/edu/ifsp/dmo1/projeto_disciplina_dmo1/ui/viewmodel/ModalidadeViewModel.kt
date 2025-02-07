package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Modalidade
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.ModalidadeRepository
import kotlinx.coroutines.launch

class ModalidadeViewModel(private val repository: ModalidadeRepository) : ViewModel() {

//    val allModalidades: LiveData<List<Modalidade>> = repository.allModalidades

    fun insert(modalidade: Modalidade) = viewModelScope.launch {
        repository.insert(modalidade)
    }

    suspend fun getModalidadeById(id: Int): LiveData<Modalidade> {
        return repository.getModalidadeById(id)
    }
}
package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.UsuarioRepository
import kotlinx.coroutines.launch

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {

    fun insert(usuario: Usuario) = viewModelScope.launch {
        repository.insert(usuario)
    }

    fun getUsuarioByEmail(email: String, onResult: (Usuario?) -> Unit) = viewModelScope.launch {
        val usuario = repository.getUsuarioByEmail(email)
        onResult(usuario)
    }

}

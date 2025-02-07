package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.UsuarioRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = UsuarioRepository(application)

    fun getUsuarioByEmail(email: String, onResult: (Usuario?) -> Unit) = viewModelScope.launch {
        val usuario = repository.getUsuarioByEmail(email)
        onResult(usuario)
    }


}
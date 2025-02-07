package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.cadastrar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.UsuarioRepository
import kotlinx.coroutines.launch

class CadastrarViewModel(application: Application): AndroidViewModel(application) {

    private val repository = UsuarioRepository(application)

    private val _insert = MutableLiveData<Boolean>()
    val insert: LiveData<Boolean> = _insert

    fun insert(usuario: Usuario) = viewModelScope.launch {
        if(repository.insert(usuario)){
            _insert.value = true
        }else{
            _insert.value = false
        }
    }

}
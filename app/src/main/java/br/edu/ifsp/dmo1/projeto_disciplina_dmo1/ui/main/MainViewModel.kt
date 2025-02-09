package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.DataStoreRepository
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.UsuarioRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = UsuarioRepository(application)
    private val datastore = DataStoreRepository(application)

    val checkboxPreferences: LiveData<Pair<Boolean, Boolean>> = datastore.checkboxPreferences.asLiveData()
    val dadosPreferences: LiveData<Pair<String, String>> = datastore.dadosPreferences.asLiveData()


    fun getUsuarioByEmail(email: String, onResult: (Usuario?) -> Unit) = viewModelScope.launch {
        val usuario = repository.getUsuarioByEmail(email)
        onResult(usuario)
    }

    fun prefereces(email: String, senha: String, salvarDados: Boolean, manterLogado: Boolean){
        if(salvarDados || manterLogado){
            savePreferences(email, senha, salvarDados, manterLogado)
        }else{
            savePreferences("", "", salvarDados, manterLogado)
        }
    }

    private fun savePreferences(email: String, senha: String, salvarDados: Boolean, manterLogado: Boolean) {
        viewModelScope.launch {
            datastore.savePreferences(email, senha, salvarDados, manterLogado)
        }
    }

}
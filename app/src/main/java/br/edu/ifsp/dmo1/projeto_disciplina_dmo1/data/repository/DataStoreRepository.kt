package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.utils.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreRepository(context: Context) {

    private val dataStore: DataStore<Preferences> = context.dataStore

    object PreferencesArq {
        const val FILE_NAME = "user_preferences"
    }

    private object PreferencesChaves {
        val SALVAR_DADOS = booleanPreferencesKey("salvar_dados")
        val MANTER_LOGADO = booleanPreferencesKey("manter_logado")
        val EMAIL = stringPreferencesKey("email")
        val SENHA = stringPreferencesKey("senha")
    }

    suspend fun savePreferences(email: String = "", senha: String = "", salvarDados: Boolean, manterLogado: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesChaves.EMAIL] = email
            preferences[PreferencesChaves.SENHA] = senha
            preferences[PreferencesChaves.SALVAR_DADOS] = salvarDados
            preferences[PreferencesChaves.MANTER_LOGADO] = manterLogado
        }
    }

    val checkboxPreferences: Flow<Pair<Boolean, Boolean>> = dataStore.data.map { preferences ->
        val salvarDados = preferences[PreferencesChaves.SALVAR_DADOS] ?: false
        val manterLogado = preferences[PreferencesChaves.MANTER_LOGADO] ?: false
        Pair(salvarDados, manterLogado)
    }

    val dadosPreferences: Flow<Pair<String, String>> = dataStore.data.map { preferences ->
        val email = preferences[PreferencesChaves.EMAIL] ?: ""
        val senha = preferences[PreferencesChaves.SENHA] ?: ""
        Pair(email, senha)
    }

}
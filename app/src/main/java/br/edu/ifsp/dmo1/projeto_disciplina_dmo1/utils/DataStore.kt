package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.DataStoreRepository

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = DataStoreRepository.PreferencesArq.FILE_NAME)
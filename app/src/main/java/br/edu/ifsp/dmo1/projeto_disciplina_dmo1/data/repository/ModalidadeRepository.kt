package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository

import android.content.Context

import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.database.AppDatabase
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Modalidade

class ModalidadeRepository(context: Context) {

    private val database = AppDatabase.getDatabase(context)
    private val dao = database.modalidadeDao()

    suspend fun getAll(): List<Modalidade>{
        return dao.getAllModalidades()
    }

    suspend fun insert(modalidade: Modalidade): Boolean {
       return dao.insert(modalidade) > 0
    }

    suspend fun getModalidadeById(id: Int): Modalidade {
        return dao.getModalidadeById(id)
    }
}
package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository

import androidx.lifecycle.LiveData
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao.ModalidadeDao
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Modalidade

class ModalidadeRepository(private val modalidadeDao: ModalidadeDao) {

//    val allModalidades: LiveData<List<Modalidade>> = modalidadeDao.getAllModalidades()

    suspend fun insert(modalidade: Modalidade) {
        modalidadeDao.insert(modalidade)
    }

    suspend fun getModalidadeById(id: Int): LiveData<Modalidade> {
        return modalidadeDao.getModalidadeById(id)
    }
}
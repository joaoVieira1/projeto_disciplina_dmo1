package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Modalidade

@Dao
interface ModalidadeDao {

    @Insert
    suspend fun insert(modalidade: Modalidade): Long

    @Query("SELECT * FROM modalidades")
    suspend fun getAllModalidades(): List<Modalidade>

    @Query("SELECT * FROM modalidades WHERE id = :id")
    suspend fun getModalidadeById(id: Int): Modalidade
}
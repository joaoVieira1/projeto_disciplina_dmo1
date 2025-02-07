package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino

@Dao
interface TreinoDao {

    @Insert
    suspend fun insert(treino: Treino)

    @Query("SELECT * FROM treinos")
    suspend fun getAllTreinos(): LiveData<List<Treino>>

    @Query("SELECT * FROM treinos WHERE professor_email = :professorEmail")
    suspend fun getTreinosByProfessorEmail(professorEmail: String): LiveData<List<Treino>>

    @Query("SELECT * FROM treinos WHERE modalidade_id = :modalidadeId")
    suspend fun getTreinosByModalidadeId(modalidadeId: Int): LiveData<List<Treino>>
}
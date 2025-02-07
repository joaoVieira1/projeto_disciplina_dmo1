package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    suspend fun insert(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE email = :email")
    suspend fun getUsuarioByEmail(email: String): Usuario


//    @Query("SELECT * FROM usuarios")
//    suspend fun getAllUsuarios(): LiveData<List<Usuario>>
}
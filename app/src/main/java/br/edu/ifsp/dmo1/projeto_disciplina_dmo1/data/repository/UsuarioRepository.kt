package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository

import android.content.Context
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.database.AppDatabase
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario

class UsuarioRepository(context: Context) {

    private val database = AppDatabase.getDatabase(context)
    private val dao = database.usuarioDao()

    suspend fun getAll(usuario: Usuario) : List<Usuario>{
      return dao.getAllUsuarios()
    }

    suspend fun insert(usuario: Usuario): Boolean {
        return dao.insert(usuario) > 0
    }

    suspend fun getUsuarioByEmail(email: String): Usuario? {
        return dao.getUsuarioByEmail(email)
    }
}
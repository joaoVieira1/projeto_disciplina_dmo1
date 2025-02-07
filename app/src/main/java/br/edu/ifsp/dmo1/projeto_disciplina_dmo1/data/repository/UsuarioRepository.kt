package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository

import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao.UsuarioDao
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario

class UsuarioRepository(private val usuarioDao: UsuarioDao) {



//    suspend fun getAll(usuario: Usuario) : LiveData<List<Usuario>>{
//        return usuarioDao.getAllUsuarios()
//    }

    suspend fun insert(usuario: Usuario): Boolean {
        return usuarioDao.insert(usuario) > 0
    }

    suspend fun getUsuarioByEmail(email: String): Usuario? {
        return usuarioDao.getUsuarioByEmail(email)
    }
}
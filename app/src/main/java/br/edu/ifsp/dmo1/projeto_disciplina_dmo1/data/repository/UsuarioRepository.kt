package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository

import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao.UsuarioDao
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario

class UsuarioRepository(private val usuarioDao: UsuarioDao) {



//    suspend fun getAll(usuario: Usuario) : LiveData<List<Usuario>>{
//        return usuarioDao.getAllUsuarios()
//    }

    suspend fun insert(usuario: Usuario) {
        usuarioDao.insert(usuario)
    }

    suspend fun getUsuarioByEmail(email: String): Usuario? {
        return usuarioDao.getUsuarioByEmail(email)
    }
}
package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.utils

import android.app.Application
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.database.AppDatabase
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.ModalidadeRepository
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.TreinoRepository
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.repository.UsuarioRepository

class MyApplication : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }

    val usuarioRepository by lazy { UsuarioRepository(database.usuarioDao()) }
    val modalidadeRepository by lazy { ModalidadeRepository(database.modalidadeDao()) }
    val treinoRepository by lazy { TreinoRepository(database.treinoDao()) }
}
package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao.ModalidadeDao
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao.TreinoDao

import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.dao.UsuarioDao
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Modalidade
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario

@Database(
    entities = [Usuario::class, Modalidade::class, Treino::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao
    abstract fun modalidadeDao(): ModalidadeDao
    abstract fun treinoDao(): TreinoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
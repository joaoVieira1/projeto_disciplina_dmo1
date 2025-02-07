package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.cadastrar

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.databinding.ActivityCadastrarBinding
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.main.MainActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.viewmodel.UsuarioViewModel
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.utils.MyApplication

class CadastrarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tiposUsuario = arrayOf("ALUNO", "PROFESSOR")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposUsuario)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTipoUsuario.adapter = adapter

        binding.buttonCadastrar.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val senha = binding.editTextSenha.text.toString()
            val tipoUsuario = binding.spinnerTipoUsuario.selectedItem.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()) {

                val usuario = Usuario(email, senha, tipoUsuario)


                val viewModel = UsuarioViewModel((application as MyApplication).usuarioRepository)
                try {

                    viewModel.insert(usuario)
                    Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }catch (e:Exception){
                    Toast.makeText(this, "Nao foi possivel cadastrar o usuario!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, CadastrarActivity::class.java)
                    startActivity(intent)
                }



            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
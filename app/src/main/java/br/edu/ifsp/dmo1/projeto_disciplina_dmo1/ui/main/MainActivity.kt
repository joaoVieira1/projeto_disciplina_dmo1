package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.aluno.AlunoActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.cadastrar.CadastrarActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.professor.ProfessorActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.viewmodel.UsuarioViewModel
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.utils.MyApplication


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val senha = binding.senhaEditText.text.toString()


            if (email.isNotEmpty() && senha.isNotEmpty()) {
                val viewModel = UsuarioViewModel((application as MyApplication).usuarioRepository)



                viewModel.getUsuarioByEmail(email) { usuario ->
                    if (usuario != null && usuario.senha == senha) {
                        Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT)
                            .show()

                        if (usuario.tipoUsuario.equals("PROFESSOR")){
                            val intent = Intent(this, ProfessorActivity::class.java)
                            startActivity(intent)
                        }else{
                            val intent = Intent(this, AlunoActivity::class.java)
                            startActivity(intent)
                        }
                    } else {
                        Toast.makeText(this, "Usuario nao cadastrado!", Toast.LENGTH_SHORT).show()
                    }


                }
            }


            binding.cadastrarButton.setOnClickListener {
                val intent = Intent(this, CadastrarActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
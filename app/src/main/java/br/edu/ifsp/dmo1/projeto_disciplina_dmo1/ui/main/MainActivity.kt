package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.databinding.ActivityMainBinding
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.aluno.AlunoActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.cadastrar.CadastrarActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.professor.ProfessorActivity



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        configListeners()
    }

    private fun configListeners(){
        binding.cadastrarButton.setOnClickListener {
            val intent = Intent(this, CadastrarActivity::class.java)
            startActivity(intent)
        }

        binding.loginButton.setOnClickListener{ logar() }
    }

    private fun logar(){
        val email = binding.emailEditText.text.toString()
        val senha = binding.senhaEditText.text.toString()

        if (email.isNotEmpty() && senha.isNotEmpty()) {
            viewModel.getUsuarioByEmail(email) { usuario ->
                if (usuario != null && usuario.senha == senha && usuario.email == email) {
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
                    Toast.makeText(this, "Email ou senha invalidos!", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this, "Informe os campos solicitados!", Toast.LENGTH_SHORT).show()
        }
    }

}
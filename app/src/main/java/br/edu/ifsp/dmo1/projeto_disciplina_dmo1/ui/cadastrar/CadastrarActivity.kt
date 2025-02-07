package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.cadastrar

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Usuario
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.databinding.ActivityCadastrarBinding
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.main.MainActivity

class CadastrarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarBinding
    private lateinit var viewModel: CadastrarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CadastrarViewModel::class.java)

        val tiposUsuario = arrayOf("ALUNO", "PROFESSOR")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposUsuario)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTipoUsuario.adapter = adapter

        configListeners()
        configObservers()

    }

    private fun configObservers(){
        viewModel.insert.observe(this, Observer {
            if(it){
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Nao foi possivel cadastrar o usuario!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CadastrarActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun configListeners(){
        binding.buttonCadastrar.setOnClickListener { cadastrar() }
    }

    private fun cadastrar(){

        val email = binding.editTextEmail.text.toString()
        val senha = binding.editTextSenha.text.toString()
        val tipoUsuario = binding.spinnerTipoUsuario.selectedItem.toString()

        if (email.isNotEmpty() && senha.isNotEmpty()) {

            val usuario = Usuario(email, senha, tipoUsuario)

            viewModel.insert(usuario)

        } else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
        }


    }

}
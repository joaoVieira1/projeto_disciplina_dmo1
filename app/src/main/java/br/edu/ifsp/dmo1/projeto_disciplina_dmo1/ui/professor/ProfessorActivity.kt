package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.professor

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.databinding.ActivityProfessorBinding
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.main.MainActivity

class ProfessorActivity: AppCompatActivity() {


    private lateinit var binding: ActivityProfessorBinding
    private lateinit var viewModel: ProfessorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfessorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ProfessorViewModel::class.java)

        val modalidades = arrayOf("FUTEBOL", "BASQUETE", "LUTA", "ACADEMIA")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, modalidades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.modalidadeSpinner.adapter = adapter


        configListeners()

    }



    private fun configListeners(){
        binding.salvarButton.setOnClickListener { cadastrar() }

        binding.logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun cadastrar(){

        val dieta = binding.dietaEditText.text.toString()
        val treino = binding.treinoEditText.text.toString()
        val modalidade = binding.modalidadeSpinner.selectedItem.toString()
        val email = intent.getStringExtra("email")?: ""

        if (dieta.isNotEmpty() && treino.isNotEmpty()) {
            viewModel.insert(Treino(email,modalidade,dieta,treino))
            Toast.makeText(this, "treino salvo!", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
        }


    }

}

package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.aluno

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.data.model.Treino
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.databinding.ActivityAlunoBinding
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.main.MainActivity
import kotlinx.coroutines.launch

class AlunoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlunoBinding
    private lateinit var viewModel: AlunoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(AlunoViewModel::class.java)

        val modalidades = arrayOf("TODOS", "FUTEBOL", "BASQUETE", "LUTA", "ACADEMIA")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, modalidades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.modalidadeFiltro.adapter = adapter

        configListeners()
    }

    private fun configListeners() {
        binding.modalidadeFiltro.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: android.view.View?, position: Int, id: Long) {
                val modalidade = parentView?.getItemAtPosition(position).toString()
                fetchTreinos(modalidade)  // Chama a função para buscar os treinos
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                fetchTreinos("TODOS")
            }
        }

        binding.logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun fetchTreinos(modalidade: String) {
        lifecycleScope.launch {
            val lista: List<Treino>
            if (modalidade == "TODOS") {
                lista = viewModel.getAll()
            } else {
                lista = viewModel.getAllByModalidade(modalidade)
            }

            updateUIWithTreinos(lista)
        }
    }

    private fun updateUIWithTreinos(treinos: List<Treino>) {

        val treinoAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, treinos.map { it })
        binding.listaDeTreinos.adapter = treinoAdapter
    }
}

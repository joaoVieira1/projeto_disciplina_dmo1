package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.professor

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.databinding.ActivityProfessorBinding

class ProfessorActivity: AppCompatActivity() {

    private lateinit var binding: ActivityProfessorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfessorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val modalidades = arrayOf("FUTEBOL", "BASQUETE", "LUTA", "ACADEMIA")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, modalidades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.modalidadeSpinner.adapter = adapter


    }
}

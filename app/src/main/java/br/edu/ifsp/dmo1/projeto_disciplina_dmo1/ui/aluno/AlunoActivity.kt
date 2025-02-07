package br.edu.ifsp.dmo1.projeto_disciplina_dmo1.ui.aluno

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo1.projeto_disciplina_dmo1.databinding.ActivityAlunoBinding

class AlunoActivity : AppCompatActivity(){

    private lateinit var binding: ActivityAlunoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlunoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val modalidades = arrayOf("FUTEBOL", "BASQUETE", "LUTA", "ACADEMIA")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, modalidades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.modalidadeFiltro.adapter = adapter

    }
}
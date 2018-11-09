package com.tavares.kaique.kaiquetavaresrm79173

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pesquisa.*

class PesquisaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        btnPesquisar.setOnClickListener {
            val resultado = Intent(this,ResultadoActivity::class.java)
            resultado.putExtra("CEP",etCep.editableText.toString())
            startActivity(resultado)
        }
    }
}

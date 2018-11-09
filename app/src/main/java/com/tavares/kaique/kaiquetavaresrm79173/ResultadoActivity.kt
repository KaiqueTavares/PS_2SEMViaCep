package com.tavares.kaique.kaiquetavaresrm79173

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tavares.kaique.kaiquetavaresrm79173.api.ViaCepService
import com.tavares.kaique.kaiquetavaresrm79173.model.Cep
import kotlinx.android.synthetic.main.activity_resultado.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val cep = intent.getStringExtra("CEP")

        val retrofit = Retrofit.Builder()
                .baseUrl("http://viacep.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<ViaCepService>(ViaCepService::class.java!!)

        service.buscarCEP(cep.toString()).enqueue(object : Callback<Cep>{
            override fun onFailure(call: Call<Cep>?, t: Throwable?) {
                Toast.makeText(this@ResultadoActivity,
                        "Erro na Obtenção dos Dados!",
                        Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Cep>?, response: Response<Cep>?) {
                val cepJSON = response?.body()
                tvLogradouro.text = cepJSON?.logradouro
                tvBairro.text = cepJSON?.bairro
                tvCidade.text = cepJSON?.cidade
                tvEstado.text = cepJSON?.estado

            }
        })

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}

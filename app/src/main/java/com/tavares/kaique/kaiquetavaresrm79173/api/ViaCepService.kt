package com.tavares.kaique.kaiquetavaresrm79173.api

import com.tavares.kaique.kaiquetavaresrm79173.model.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("/ws/{cep}/json/")
    fun buscarCEP(@Path("cep") cep: String):Call<Cep>
}
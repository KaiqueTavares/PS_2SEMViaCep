package com.tavares.kaique.kaiquetavaresrm79173.model

import com.google.gson.annotations.SerializedName

data class Cep (
        @SerializedName("logradouro") val logradouro:String,
        @SerializedName("bairro") val bairro:String,
        @SerializedName("localidade") val cidade:String,
        @SerializedName("uf") val estado:String)
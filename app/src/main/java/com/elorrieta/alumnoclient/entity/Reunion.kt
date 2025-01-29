package com.elorrieta.alumnoclient.entity

data class Reunion(
    private var idReunion: Int? = null,
    private var solicitante: String,
    private var receptor: String,
    private var estado: String? = null,
    private var titulo: String? = null,
    private var asunto: String
)

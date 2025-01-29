package com.elorrieta.alumnoclient.entity

data class HorarioReunion(
    private val idHorarioReunion: Int? = null,
    private val dia: String,
    private val hora: Int,
    private val aula: Int? = null,
    private val idReunion: Int? = null
)

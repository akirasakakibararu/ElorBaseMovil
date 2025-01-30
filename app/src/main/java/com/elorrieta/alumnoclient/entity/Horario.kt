package com.elorrieta.alumnoclient.entity

data class Horario(
    private val idHorario: Int? = null,
    private val hora: Int,
    private val dia: String,
    private val aula: Int? = null,
    private val idAsignatura: String
)

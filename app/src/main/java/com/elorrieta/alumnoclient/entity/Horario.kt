package com.elorrieta.alumnoclient.entity

data class Horario(
    val idHorario: Int? = null,
    val hora: Int,
    val dia: String,
    val aula: Int? = null,
    val idAsignatura: String
)

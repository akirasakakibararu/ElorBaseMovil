package com.elorrieta.alumnoclient.entity

data class Asignatura(
    val idAsignatura: String,
    val nombre: String,
    val horasTotales: Int,
    val curso: Int? = null,
    val idProfesor: Int? = null
)

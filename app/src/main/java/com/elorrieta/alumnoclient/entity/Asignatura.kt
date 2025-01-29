package com.elorrieta.alumnoclient.entity

data class Asignatura(
    private val idAsignatura: String,
    private val nombre: String,
    private val horasTotales: Int,
    private val curso: Int? = null,
    private val idProfesor: Int? = null
)

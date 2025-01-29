package com.elorrieta.alumnoclient.entity

import java.sql.Date

data class Matriculacion(
    private val idAlumno: Int,
    private val idCiclo: String,
    private val modalidad: String,
    private val curso: Int,
    private val fecha: Date
)

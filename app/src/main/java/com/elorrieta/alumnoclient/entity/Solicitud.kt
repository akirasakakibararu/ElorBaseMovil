package com.elorrieta.alumnoclient.entity

data class Solicitud(
    private var idReunion: Int,
    private var idProfesor: Int,
    private var confirmada: String? = null
)

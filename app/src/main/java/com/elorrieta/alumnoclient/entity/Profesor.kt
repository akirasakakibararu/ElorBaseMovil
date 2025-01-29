package com.elorrieta.alumnoclient.entity

data class Profesor(
    private val idProfesor: Int,
    private var email: String? = null,
    private val contrasenna: Int,
    private val dni: String,
    private var nombre: String,
    private var apellidos: String,
    private var direccion: String? = null,
    private var telefono1: String,
    private var telefono2: String? = null
)

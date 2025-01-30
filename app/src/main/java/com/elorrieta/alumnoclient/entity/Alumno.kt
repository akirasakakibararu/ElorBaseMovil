package com.elorrieta.alumnoclient.entity

/**
 * The entity Alumno, used to manipulate data as objects instead of JSON
 */
/*data class Alumno (private val id: Int, private val name: String, private val surname: String,
    private val pass: String, private val edad: Int)*/

data class Alumno(
    private val idAlumno: Int,
    private val email: String? = null,
    private val contrasenna: Int,
    private val dni: String,
    private val nombre: String,
    private val apellidos: String,
    private val direccion: String? = null,
    private val telefono1: String,
    private val telefono2: String? = null,
    private val foto: ByteArray? = null
)
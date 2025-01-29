package com.elorrieta.alumnoclient.entity

/**
 * The entity Alumno, used to manipulate data as objects instead of JSON
 */
/*data class Alumno (private val id: Int, private val name: String, private val surname: String,
    private val pass: String, private val edad: Int)*/

data class Alumno(
    private var idAlumno: Int,
    private var email: String? = null,
    private var contrasenna: Int,
    private var dni: String,
    private var nombre: String,
    private var apellidos: String,
    private var direccion: String? = null,
    private var telefono1: String,
    private var telefono2: String? = null,
    private var foto: ByteArray? = null
)
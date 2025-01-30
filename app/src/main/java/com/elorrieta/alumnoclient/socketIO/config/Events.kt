package com.elorrieta.socketsio.sockets.config

/**
 * The events our client is willing to listen or able to send. It is
 * the same class as in the Java Server
 */
enum class Events(val value: String) {
    ON_LOGIN ("onLogin"),
    ON_GET_ALL ("onGetAll"),
    ON_LOGOUT ("onLogout"),
    ON_LOGIN_ANSWER ("onLoginAnswer"),
    ON_GET_ALL_ANSWER ("onGetAllAnswer"),
    OBTENER_ASIGNATURAS ("obtenerAsignaturas"),

    GET_HORARIO_SEMANAL_PROFESOR ("getHorarioSemanalProfesor"),
    GET_HORARIO_SEMANAL_PROFESOR_ANSWER ("getHorarioSemanalProfesorAnswer"),
    GET_REUNION ("getReunion"),
    GET_HORARIO_SEMANAL_ALUMNO ("getHorarioSemanalAlumno"),
    GET_ALL_OFERTA_CURSOS ("getAllOfertaCursos"),
}
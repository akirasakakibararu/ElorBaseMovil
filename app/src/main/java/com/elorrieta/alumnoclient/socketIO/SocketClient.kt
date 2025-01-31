package com.elorrieta.alumnoclient.socketIO

import android.app.Activity
import android.util.Log
import android.widget.TextView
import com.elorrieta.alumnoclient.R
import com.elorrieta.alumnoclient.entity.Alumno
import com.elorrieta.alumnoclient.entity.Asignatura
import com.elorrieta.alumnoclient.entity.Horario
import com.elorrieta.alumnoclient.socketIO.model.MessageInput
import com.elorrieta.socketsio.sockets.config.Events
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONObject


/**
 * The client
 */
class SocketClient (private val activity: Activity) {

    // Server IP:Port
    private val ipPort = "http://10.0.2.2:3000"
    private val socket: Socket = IO.socket(ipPort)

    // For log purposes
    private var tag = "socket.io"

    // We add here ALL the events we are eager to LISTEN from the server
    init {

        // Event called when the socket connects
        socket.on(Socket.EVENT_CONNECT) {
            Log.d(tag, "Connected...")
        }

        // Event called when the socket disconnects
        socket.on(Socket.EVENT_DISCONNECT) {
            Log.d(tag, "Disconnected...")
        }



        // Event called when the socket gets an answer from a login attempt.
        // We get the message and print it. Note: this event is called after
        // We try to login
        socket.on(Events.ON_LOGIN_ANSWER.value) { args ->

            // The response from the server is a JSON
            val response = args[0] as JSONObject

            // The answer should be like this:
            // {"id": 0, "name": "patata", "surname": "potato", "pass": "pass", "edad": 20}
            // We extract the field 'message'
            val message = response.getString("message") as String

            // We parse the JSON into an Alumno because... ¯_(ツ)_/¯
            val gson = Gson()
            val jsonObject = gson.fromJson(message, JsonObject::class.java)
            val id = jsonObject["id"].asInt
            val name = jsonObject["name"].asString
            val surname = jsonObject["surname"].asString
            val pass = jsonObject["pass"].asString
            val edad = jsonObject["edad"].asInt

            val alumno = Alumno(id, name, surname, pass, edad)

            // And... we list the Alumno in the list and in the Log
            activity.findViewById<TextView>(R.id.textView).append("\nAnswer to Login:$alumno")
            Log.d(tag, "Answer to Login: $alumno")
        }

        // Event called when the socket gets an answer from a getAll.
        // We get the message and print it.
        socket.on(Events.ON_GET_ALL_ANSWER.value) { args ->

            // The response from the server is a JSON
            val response = args[0] as JSONObject

            // The answer should be like this:
            // [
            // {"id":0,"name":"patata","surname":"potato","pass":"pass","edad":20},
            // {"id":1,"name":"patata2","surname":"potato2","pass":"pass2","edad":22},
            // {"id":2,"name":"patata3","surname":"potato3","pass":"pass3","edad":23}
            // ]
            // We extract the field 'message'
            val message = response.getString("message") as String

            // We parse the JSON. Note we use Alumno to parse the server response
            val gson = Gson()
            val itemType = object : TypeToken<List<Alumno>>() {}.type
            val list = gson.fromJson<List<Alumno>>(message, itemType)

            // The logging
            activity.findViewById<TextView>(R.id.textView).append("\nAnswer to getAll:$list")
            Log.d(tag, "Answer to getAll: $list")
        }
    }

    // Default events

    // This method is called when we want to establish a connection with the server
    fun connect() {
        socket.connect()

        // Log traces
        activity.findViewById<TextView>(R.id.textView).append("\n" + "Connecting to server...")
        Log.d (tag, "Connecting to server...")
    }

    // This method is called when we want to disconnect from the server
    fun disconnect() {
        socket.disconnect()

        // Log traces
        activity.findViewById<TextView>(R.id.textView).append("\n" + "Disconnecting from server...")
        Log.d (tag, "Disconnecting from server...")
    }

    // Custom events

    // This method is called when we want to login. We get the userName,
    // put in into an MessageOutput, and convert it into JSON to be sent
    fun doLogin(userName: String) {
        val message = MessageInput(userName) // The server is expecting a MessageInput
        socket.emit(Events.ON_LOGIN.value, Gson().toJson(message))

        // Log traces
        activity.findViewById<TextView>(R.id.textView).append("\nAttempt of login - $message")
        Log.d (tag, "Attempt of login - $message")
    }

    // This method is called when we want to getAll the Alumno.
    fun doGetAll() {
        socket.emit(Events.ON_GET_ALL.value)

        // Log traces
        activity.findViewById<TextView>(R.id.textView).append("\nAttempt of getAll...")
        Log.d (tag, "Attempt of getAll...")
    }

    // This method is called when we want to logout. We get the userName,
    // put in into an MessageOutput, and convert it into JSON to be sent
    fun doLogout(userName: String) {
        val message = MessageInput(userName) // The server is expecting a MessageInput
        socket.emit(Events.ON_LOGOUT.value, Gson().toJson(message))

        // Log traces
        activity.findViewById<TextView>(R.id.textView).append("\nAttempt of Logout - $message")
        Log.d (tag, "Attempt of logout - $message")
    }

    fun obtenerAsignaturas() {
        socket.emit(Events.OBTENER_ASIGNATURAS.value)

        activity.findViewById<TextView>(R.id.textView).append("\nAttempt of obtenerAsignaturas...")
        Log.d (tag, "Attempt of obtenerAsignaturas...")
    }

    fun obtenerHorarioProfesor() {
        socket.emit(Events.GET_HORARIO_SEMANAL_PROFESOR.value)

        activity.findViewById<TextView>(R.id.textView).append("\nAttempt of obtenerHorario...")
        Log.d (tag, "Attempt of obtenerHorario...")
    }
}
package com.elorrieta.alumnoclient

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.elorrieta.alumnoclient.socketIO.SocketClient

class MainActivity : AppCompatActivity() {

    private var socketClient : SocketClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        socketClient = SocketClient(this)

        findViewById<Button>(R.id.buttonConnect)
            .setOnClickListener {
                socketClient!!.connect()
                Thread.sleep(3000) // A little delay...
            }

        findViewById<Button>(R.id.buttonDisconnect)
            .setOnClickListener {
                socketClient!!.disconnect()
                Thread.sleep(3000) // A little delay...
            }

        findViewById<Button>(R.id.buttonLogin)
            .setOnClickListener {
                socketClient!!.doLogin("patata")
                Thread.sleep(3000) // A little delay...
            }

        findViewById<Button>(R.id.buttonGetAll)
            .setOnClickListener {
                socketClient!!.obtenerHorarioProfesor()
                Thread.sleep(3000) // A little delay...
            }

        findViewById<Button>(R.id.buttonLogout)
            .setOnClickListener {
                socketClient!!.doLogout("patata")
                Thread.sleep(3000) // A little delay...
            }

    }

    // Anctivity lifecycle, better close the socket...
    override fun onDestroy() {
        super.onDestroy()
        socketClient!!.disconnect()
    }
}
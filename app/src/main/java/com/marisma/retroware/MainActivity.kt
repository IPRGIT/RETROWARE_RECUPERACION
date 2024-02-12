package com.marisma.retroware

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}


/*
package com.marisma.retroware

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //intent para detectar si se ha pulsado salir.
        if(intent.getBooleanExtra("Exit",false))
            finish()

        //Enlace al botón e incorporación de evento "click".
        val btnAnswer = findViewById<Button>(R.id.buttonInfo)
        btnAnswer.setOnClickListener {
            goToElection()
        }
    }

    fun goToElection() {
        //crear el intent
        val intent = Intent(this@MainActivity, CreditActivity::class.java)
        //tomar el valor del cuadro de texto.
        val nombreUsuario = this.findViewById<EditText>(R.id.editTextUsername)
        //añadimos la información necesaria al intent
        intent.putExtra("USER", nombreUsuario.text.toString())

        //iniciar la nueva actividad
        startActivity(intent)
    }

    companion object {
        const val LIFECICLE = "LifeCycle"
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LIFECICLE,"La Activity ha sido reiniciada (Restarted)")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECICLE,"La Activity ha sido iniciada (Started)")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECICLE,"La Activity ha pasado a primer plano (Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECICLE,"La Activity ha sido pausada (Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECICLE,"La Activity ha sido parada (Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECICLE,"La Activity ha sido destruida (Destroyed)")
    }
}
*/
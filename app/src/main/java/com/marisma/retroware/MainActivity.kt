package com.marisma.retroware

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.marisma.retroware.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        // Configurar el botón de retroceso del dispositivo
        configureBackButton()

        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.navHostFragment.id) as NavHostFragment
        val navController = navHostFragment.navController


        val username = intent.getStringExtra("username")
        if (username.isNullOrEmpty()) {
            // El campo de nombre de usuario está vacío o nulo, navegar hacia el fragmento de inicio de sesión
            navController.navigate(R.id.loginFragment)
        }

//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.mainFragment))
//        setupActionBarWithNavController(navController, appBarConfiguration)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!navController.navigateUp()) {
                    finish()
                }
            }
        })
    }

    // Método para configurar el botón de retroceso del dispositivo
    private fun configureBackButton() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
                val currentFragment = navHostFragment.childFragmentManager.primaryNavigationFragment
                if (currentFragment is MenuFragment) {
                    // Si el fragmento actual es MenuFragment, utiliza su NavController
                    val navController = currentFragment.findNavController()
                    navController.popBackStack()
                } else {
                    // Si no es MenuFragment, permite el comportamiento normal del botón de retroceso
                    isEnabled = false
                    handleOnBackPressed()
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(binding.navHostFragment.id)
        val navHostFragment = supportFragmentManager
            .findFragmentById(binding.navHostFragment.id) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp() || super.onSupportNavigateUp()

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
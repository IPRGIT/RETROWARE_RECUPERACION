package com.marisma.retroware

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.marisma.retroware.data.DataSource
import com.marisma.retroware.data.Videojuego
import com.marisma.retroware.databinding.FragmentDetailItemBinding

/*class DetailItemFragment : Fragment() {
    private lateinit var binding: FragmentDetailItemBinding
    private val args: DetailItemFragmentArgs by navArgs()
    val nombreVideojuego = arguments?.getString("nombreVideojuego")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access the arguments passed from the navigation
        val user = args.user

        if(nombreVideojuego!=null) {
            val videojuego = crearVideojuegoDesdeNombre(nombreVideojuego)

            binding.titulo.text = videojuego?.nombre
            binding.anio.text = "Año de lanzamiento: ${videojuego?.anioLanzamiento}"
            binding.genero.text = "Género: ${videojuego?.genero?.joinToString(", ")}"
            if (binding.plataformas.text != null) {
                binding.plataformas.text =
                    "Plataformas: ${videojuego?.plataformas?.toList()?.joinToString(", ")}"
            }
            *//*binding.plataformas.text = "Plataformas: ${videojuego?.plataformas?.joinToString(", ") { it.toString() }}"
        binding.plataformas.text = "Plataformas: ${videojuego?.plataformas?.joinToString(", ") { it }}"*//*
            // Agrega cualquier otra información que desees mostrar en el fragmento de detalle

            Glide.with(binding.caratula.context).load(videojuego?.caratula).into(binding.caratula)
        }

        // Use the user argument as needed
        // For example, you can set a text view with the user's name
        //binding.textViewUser.text = "User: $user"
    }

    // metodo pare crear un videojuego dado el nombre
    fun crearVideojuegoDesdeNombre(nombre: String): Videojuego? {
        for (videojuego in DataSource.ListaVideojuegos) {
            if (videojuego.nombre == nombre) {
                return videojuego
            }
        }
        return null // Devuelve null si no se encuentra el videojuego con el nombre especificado
    }
}*/

class DetailItemFragment : Fragment() {
    private lateinit var binding: FragmentDetailItemBinding
    private val args: DetailItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nombreVideojuego = args.nombreVideojuego

        if (nombreVideojuego != null) {
            val videojuego = crearVideojuegoDesdeNombre(nombreVideojuego)

            binding.titulo.text = videojuego?.nombre
            binding.anio.text = "Año de lanzamiento: ${videojuego?.anioLanzamiento}"
            binding.genero.text = "Género: ${videojuego?.genero?.joinToString(", ")}"
            binding.plataformas.text = "Plataformas: ${videojuego?.plataformas?.toList()?.joinToString(", ")}"

            Glide.with(binding.caratula.context).load(videojuego?.caratula).into(binding.caratula)
        }
    }

    private fun crearVideojuegoDesdeNombre(nombre: String): Videojuego? {
        for (videojuego in DataSource.ListaVideojuegos) {
            if (videojuego.nombre == nombre) {
                return videojuego
            }
        }
        return null
    }
}






/*
package com.marisma.retroware

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.NavArgsLazy
import androidx.navigation.fragment.navArgs
import com.marisma.retroware.databinding.FragmentDetailItemBinding
import com.marisma.retroware.databinding.FragmentItemListBinding
import kotlin.reflect.KProperty

class DetailItemFragment : Fragment() {

   */
/* val args:DetailItemFragment by navArgs<DetailItemFragment>()
    private lateinit var binding: FragmentDetailItemBinding*//*



    val args:MenuFragmentArgs by navArgs<MenuFragmentArgs>()

    private lateinit var binding:FragmentItemListBinding

    */
/*

    private var _binding: FragmentCreditBinding? = null
        private val binding get() = _binding!!
        val args:CreditFragmentArgs by navArgs()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentCreditBinding.inflate(inflater, container, false)

            binding.contactarButton.setOnClickListener {
                enviarCorreo()
            }

            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val user = args.user
            binding.mensajeVersion.apply {
                //toma la cadena "version" y le incorpora el valor de los strings usuario app_version y app_name
                text = getString(R.string.version, user,getString(R.string.app_version), getString(R.string.app_name))
            }
        }
     *//*


    private var _binding: FragmentDetailItemBinding? = null
    //private val binding get() = _binding!!
    //val args:DetailItemFragment by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailItemBinding.inflate(inflater, container, false)

        */
/*binding.contactarButton.setOnClickListener {
            enviarCorreo()
        }*//*


        return binding.root
    }



        */
/*

        binding.titulo.text = videojuego.nombre
        binding.anio.text = listOf(binding.anio.text, videojuego.anioLanzamiento.toString()).joinToString(": ")
        binding.genero.text = "${binding.genero.text}, ${videojuego.genero.joinToString(", ")}"
        binding.plataformas.text = videojuego.plataformas.toString()
        binding.plataforma.text = if (videojuego.plataforma.size > 3) {
            // Si hay más de 3 géneros, se muestra solo los primeros 3 seguidos de "..."
            videojuego.plataforma.take(3).joinToString(", ") + "..."
        } else {
            // Si hay 3 o menos géneros, se muestra todos los géneros
            videojuego.plataforma.joinToString(", ")

        }
        Glide.with(binding.caratula.context).load(videojuego.caratula).into(binding.caratula)
        itemView.setOnClickListener{ onClickListener(videojuego)}

         *//*



    */
/*companion object {
        *//*
*/
/**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailItemFragment.
         *//*
*/
/*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*//*

}

*/

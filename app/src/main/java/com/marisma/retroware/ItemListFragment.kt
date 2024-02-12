package com.marisma.retroware

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.NavArgsLazy
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgument
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marisma.retroware.adapter.VideojuegoAdapter
import com.marisma.retroware.data.DataSource
import com.marisma.retroware.data.Videojuego
import com.marisma.retroware.databinding.FragmentItemListBinding
import kotlin.reflect.KProperty

class ItemListFragment : Fragment() {
    //private var _binding: FragmentItemListBinding? = null
    //private val binding get() = _binding!!
    val args:MenuFragmentArgs by navArgs<MenuFragmentArgs>()

    private lateinit var binding:FragmentItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(inflater, container, false)
        initRecyclerView()

    val user = args.user

        /*binding.detallesButton.setOnClickListener {
            findNavController().navigate(ItemListFragmentDirections.actionItemListFragmentToDetailItemFragment())

        }*/
        /*binding.btSalir.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToLoginFragment())
        }*/

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val user = args.user
        //binding.usuario.text = user
    }

    private fun initRecyclerView(){
        binding.RecycleViewVideojuegos.layoutManager = LinearLayoutManager(context)
        /*binding.RecycleViewVideojuegos.adapter =
            VideojuegoAdapter(DataSource.ListaVideojuegos) { videojuego ->
                onItemSelected(
                    videojuego
                )
            }*/
        binding.RecycleViewVideojuegos.adapter =
            VideojuegoAdapter(DataSource.ListaVideojuegos) { videojuego ->
                onItemSelected(
                    videojuego
                )
            }
    }

    fun onItemSelected(videojuego: Videojuego){
        findNavController().navigate(ItemListFragmentDirections.actionItemListFragmentToDetailItemFragment(videojuego.nombre,args.user))
    }


    /*fun onItemSelected(videojuego: Videojuego){
        findNavController().navigate(ItemListFragmentDirections.actionItemListFragmentToDetailItemFragment(args.user
        ))
    }*/

    fun onItemSelected(nombreVideojuego: String) {
        findNavController().navigate(
            ItemListFragmentDirections.actionItemListFragmentToDetailItemFragment(
                nombreVideojuego = nombreVideojuego,
                user = args.user
            )
        )
    }


    /*binding.buttonLogin.setOnClickListener {
        var username = "Guest user"
        if(binding.editTextUsername.text.isNotEmpty()){
            username = binding.editTextUsername.text.toString()
        }
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMenuFragment(user = username))
    }*/
}
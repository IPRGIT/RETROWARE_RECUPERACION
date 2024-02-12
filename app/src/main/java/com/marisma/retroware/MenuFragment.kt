package com.marisma.retroware

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.navigation.fragment.findNavController
import com.marisma.retroware.databinding.FragmentMenuBinding
import com.marisma.retroware.databinding.FragmentFavItemListBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    val args:MenuFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val user = args.user

        binding.btHome.setOnClickListener {

            val uri = Uri.parse("@id/home_navigation.xml")
            findNavController().navigate(uri)
        }
        binding.btFav.setOnClickListener {
            //findNavController().navigate(MenuFragmentDirections(app:destination="@id/favorites_navigation.xml"))
            val uri = Uri.parse("@id/favorites_navigation.xml")
            findNavController().navigate(uri)
        }
        /*binding.btSetting.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToLoginFragment())
        }*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val user = args.user
        //binding.usuario.text = user
    }
}
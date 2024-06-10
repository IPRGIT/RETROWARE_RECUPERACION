package com.marisma.retroware

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.marisma.retroware.databinding.FragmentLoginBinding
import com.marisma.retroware.databinding.FragmentMenuBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    //private var _binding: FragmentLoginBinding? = null
    //private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        //_binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.buttonLogin.setOnClickListener {
            var username = "Guest user"
            if(binding.editTextUsername.text.isNotEmpty()){
                username = binding.editTextUsername.text.toString()
                val bundle = Bundle().apply {
                    putString("username", username)
                }
            }
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMenuFragment(user = username))
        }

        return binding.root
    }
}
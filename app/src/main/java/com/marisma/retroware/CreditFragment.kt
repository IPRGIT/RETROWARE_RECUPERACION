package com.marisma.retroware

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.marisma.retroware.databinding.FragmentCreditBinding

class CreditFragment : Fragment() {
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

    private fun enviarCorreo() {
        val destinatarios = arrayOf(getString(R.string.email_contacto))
        val asunto = getString(R.string.email_asunto)
        val cuerpo = getString(R.string.email_cuerpo)

        val int = Intent(Intent.ACTION_SENDTO)

        int.putExtra(Intent.EXTRA_EMAIL, destinatarios)
        int.putExtra(Intent.EXTRA_SUBJECT, asunto)
        int.putExtra(Intent.EXTRA_TEXT, cuerpo)

        try {
            startActivity(int)
        }catch (e: Exception){
            Toast.makeText(context,"No se pudo enviar el email",Toast.LENGTH_LONG).show()
        }
    }*/
}
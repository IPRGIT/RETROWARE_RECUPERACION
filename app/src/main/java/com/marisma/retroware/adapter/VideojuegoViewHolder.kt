package com.marisma.retroware.adapter

import android.view.View
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

import com.marisma.retroware.data.Videojuego
import com.marisma.retroware.databinding.ItemVideojuegoBinding

class VideojuegoViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val binding = ItemVideojuegoBinding.bind(view)

    fun render(videojuego: Videojuego, onClickListener: (Videojuego) -> Unit){

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
    }

}
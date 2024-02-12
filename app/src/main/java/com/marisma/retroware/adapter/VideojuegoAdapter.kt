package com.marisma.retroware.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marisma.retroware.R
import com.marisma.retroware.data.DataSource
import com.marisma.retroware.data.Videojuego

class VideojuegoAdapter(private val ListaVideojuegos:List<Videojuego>, private val onClickListener: (Videojuego) -> Unit) : RecyclerView.Adapter<VideojuegoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideojuegoViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        return VideojuegoViewHolder(layoutInflater.inflate(R.layout.item_videojuego, parent, false))
    }

    override fun onBindViewHolder(holder: VideojuegoViewHolder, position: Int) {
        val item = ListaVideojuegos[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
    return ListaVideojuegos.size
    }
}
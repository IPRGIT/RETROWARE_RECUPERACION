package com.marisma.retroware.data

import java.time.Year

data class Videojuego(
    val nombre: String,
    val desarrollador: String,
    val Publisher: String,
    val anioLanzamiento: Int,
    val genero: Array<String>,
    val plataformas: String,
    val plataforma: Array<String>,
    val descripcion: String,
    val caratula: String
)

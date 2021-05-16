package com.example.prog_web_1.presentation.api

import com.example.prog_web_1.presentation.liste.Pokemon

data class PokemonResponse(
    val count: Int,
    val next: String,
    val results: List<Pokemon>
)
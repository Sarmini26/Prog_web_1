package com.example.prog_web_1.presentation.liste

sealed class PokemonModel

data class PokemonSuccess(val pokeList: List<Pokemon>) : PokemonModel()
object PokemonLoader : PokemonModel()
object PokemonError : PokemonModel()
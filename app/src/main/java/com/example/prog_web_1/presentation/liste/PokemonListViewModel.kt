package com.example.prog_web_1.presentation.liste

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prog_web_1.presentation.Singletons
import com.example.prog_web_1.presentation.api.PokemonListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListViewModel : ViewModel(){
    val pokeList : MutableLiveData<PokemonModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        pokeList. value = PokemonLoader

        Singletons.pokeApi.getPokemonList().enqueue(object : Callback<PokemonListResponse>{
            override fun onFailure(
                    call: Call<PokemonListResponse>,
                    t: Throwable) {
                pokeList. value = PokemonError
            }

            override fun onResponse(
                    call: Call<PokemonListResponse>,
                    response: Response<PokemonListResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val pokemonResponse = response.body()!!
                    pokeList. value = PokemonSuccess(pokemonResponse.results)
                }
                else{
                    pokeList. value = PokemonError
                }
            }

        })
    }

}
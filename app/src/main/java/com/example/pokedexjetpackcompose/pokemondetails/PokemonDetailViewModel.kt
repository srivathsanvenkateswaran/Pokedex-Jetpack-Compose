package com.example.pokedexjetpackcompose.pokemondetails

import androidx.lifecycle.ViewModel
import com.example.pokedexjetpackcompose.data.remote.response.Pokemon
import com.example.pokedexjetpackcompose.repository.PokemonRepository
import com.example.pokedexjetpackcompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}
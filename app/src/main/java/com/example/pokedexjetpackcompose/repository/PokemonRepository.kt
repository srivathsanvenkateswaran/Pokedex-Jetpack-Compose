package com.example.pokedexjetpackcompose.repository

import com.example.pokedexjetpackcompose.data.remote.PokeApi
import com.example.pokedexjetpackcompose.data.remote.response.Pokemon
import com.example.pokedexjetpackcompose.data.remote.response.PokemonList
import com.example.pokedexjetpackcompose.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Resource<PokemonList>{
        val response = try{
            api.getPokemonList(
                limit = limit,
                offset = offset
            )
        }catch (e: Exception){
            return Resource.Error(message="An unknown error occurred.")
        }

        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(
        pokemonName: String
    ): Resource<Pokemon>{
        val response = try{
            api.getPokemonInfo(
                name = pokemonName
            )
        }catch (e: Exception){
            return Resource.Error(message="An unknown error occurred.")
        }

        return Resource.Success(response)
    }


}
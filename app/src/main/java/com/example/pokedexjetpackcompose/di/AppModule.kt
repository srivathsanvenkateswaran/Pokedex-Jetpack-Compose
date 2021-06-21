package com.example.pokedexjetpackcompose.di

import com.example.pokedexjetpackcompose.data.remote.PokeApi
import com.example.pokedexjetpackcompose.repository.PokemonRepository
import com.example.pokedexjetpackcompose.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonRepository(
        api: PokeApi
    ): PokemonRepository = PokemonRepository(api)

    @Provides
    @Singleton
    fun providePokeApi(): PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }
}
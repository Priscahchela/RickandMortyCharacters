package com.example.rickandmortycharacters



import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>

}
data class CharacterResponse(
    val results: List<CharacterResult>
)
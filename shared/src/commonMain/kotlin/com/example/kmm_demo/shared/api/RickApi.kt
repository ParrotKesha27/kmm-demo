package com.example.kmm_demo.shared.api

import com.example.kmm_demo.shared.entity.ListResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RickApi : KoinComponent {

    private val httpClient: HttpClient by inject()

    suspend fun getAllCharacters(): ListResponse {
        return httpClient.get("${API_ENDPOINT}/character")
    }

    companion object {
        private const val API_ENDPOINT = "https://rickandmortyapi.com/api"
    }
}

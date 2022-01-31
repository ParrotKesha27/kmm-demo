package com.example.kmm_demo.shared.di

import com.example.kmm_demo.shared.api.RickApi
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.dsl.module

val apiModule = module {
    single {
        RickApi()
    }

    single {
        httpClient()
    }
}

fun httpClient() = HttpClient {
    install(JsonFeature) {
        val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
        serializer = KotlinxSerializer(json)
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.INFO
    }
}

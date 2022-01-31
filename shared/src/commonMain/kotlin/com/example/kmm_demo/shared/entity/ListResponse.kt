package com.example.kmm_demo.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class ListResponse(
    val results: List<Character>
)

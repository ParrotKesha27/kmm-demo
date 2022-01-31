package com.example.kmm_demo.shared.entity

import kotlinx.serialization.Serializable

@Serializable
data class Origin(
    val name: String,

    val url: String
)

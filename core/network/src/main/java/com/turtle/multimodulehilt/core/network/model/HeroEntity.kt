package com.turtle.multimodulehilt.core.network.model

import com.turtle.multimodulehilt.core.model.Hero

data class HeroJsonBodyEntity(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: HeroJsonDataBodyEntity
)

data class HeroJsonDataBodyEntity(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Hero>
)
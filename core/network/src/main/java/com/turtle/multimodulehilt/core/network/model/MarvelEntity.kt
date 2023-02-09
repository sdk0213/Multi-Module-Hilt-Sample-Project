package com.turtle.multimodulehilt.core.network.model

import com.turtle.multimodulehilt.core.model.Comic
import com.turtle.multimodulehilt.core.model.Hero

data class CharacterDataWrapperEntity(
    val data: CharacterDataContainerEntity
)

data class CharacterDataContainerEntity(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Hero>
)

data class ComicDataWrapperEntity(
    val data: ComicDataContainerEntity
)

data class ComicDataContainerEntity(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Comic>
)

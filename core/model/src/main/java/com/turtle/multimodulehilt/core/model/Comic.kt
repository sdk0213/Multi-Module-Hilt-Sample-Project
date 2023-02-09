package com.turtle.multimodulehilt.core.model

data class ComicDataWrapper(
    val data: ComicDataContainer
)

data class ComicDataContainer(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Comic>
)


data class Comic(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val thumbnail: ComicThumbnail = ComicThumbnail(),
)

data class ComicThumbnail(
    val path: String = "", // 썸네일 다운로드 위치
    val extension: String = "", // 확장자
)
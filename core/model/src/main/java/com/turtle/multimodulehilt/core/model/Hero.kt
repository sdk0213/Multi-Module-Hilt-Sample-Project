package com.turtle.multimodulehilt.core.model

data class HeroJsonBody(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: HeroJsonDataBody
)

data class HeroJsonDataBody(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Hero>
)

data class Hero(
    val id: Int = 0,
    val name: String = "0",
    val description: String = "0",
    val modified: String,
    val thumbnail: HeroThumbnail,
    val resourceURI: String = "0",
    val comics: HeroComics,
    val series: HeroSeries,
    val stories: HeroStories,
    val events: HeroEvents,
    val urls: List<HeroUrl>,
)

data class HeroThumbnail(
    val path: String = "", // 썸네일 다운로드 위치
    val extension: String = "" // 확장자
)

data class HeroComics(
    val available: Int,
    val collectionURI: String,
    val items: List<HeroComicsItem>,
    val returned: Int
)

data class HeroComicsItem(
    val resourceURI: String,
    val name: String
)

data class HeroSeries(
    val available: Int,
    val collectionURI: String,
    val items: List<HeroSeriesItem>,
    val returned: Int
)

data class HeroSeriesItem(
    val resourceURI: String,
    val name: String
)

data class HeroStories(
    val available: Int,
    val collectionURI: String,
    val items: List<HeroStoriesItem>,
    val returned: Int
)

data class HeroStoriesItem(
    val resourceURI: String,
    val name: String,
    val type: String
)

data class HeroEvents(
    val available: Int,
    val collectionURI: String,
    val items: List<HeroEventsItem>,
    val returned: Int
)

data class HeroEventsItem(
    val resourceURI: String,
    val name: String,
    val type: String
)

data class HeroUrl(
    val type: String,
    val url: String
)

data class LoadPage(
    val nowPage: Int,
    val totalPage: Int
)
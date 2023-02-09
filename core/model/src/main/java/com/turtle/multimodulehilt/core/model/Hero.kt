package com.turtle.multimodulehilt.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class CharacterDataWrapper(
    val data: CharacterDataContainer = CharacterDataContainer()
)

data class CharacterDataContainer(
    val offset: Int = 0,
    val limit: Int = 0,
    val total: Int = 0,
    val count: Int = 0,
    val results: List<Hero> = emptyList()
)

@Parcelize
data class Hero(
    val id: Int = 0,
    val name: String = "",
    val description: String = "No Description",
    val modified: String = "",
    val thumbnail: HeroThumbnail = HeroThumbnail(),
    val resourceURI: String = "",
    val comics: HeroComics = HeroComics(),
    val series: HeroSeries = HeroSeries(),
    val stories: HeroStories = HeroStories(),
    val events: HeroEvents = HeroEvents(),
    val urls: List<HeroUrl> = emptyList(),
) : Parcelable

@Parcelize
data class HeroThumbnail(
    val path: String = "", // 썸네일 다운로드 위치
    val extension: String = "" // 확장자
) : Parcelable

@Parcelize
data class HeroComics(
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<HeroComicsItem> = emptyList(),
    val returned: Int = 0
) : Parcelable

@Parcelize
data class HeroComicsItem(
    val resourceURI: String = "",
    val name: String = ""
) : Parcelable

@Parcelize
data class HeroSeries(
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<HeroSeriesItem> = emptyList(),
    val returned: Int = 0
) : Parcelable

@Parcelize
data class HeroSeriesItem(
    val resourceURI: String = "",
    val name: String = ""
) : Parcelable

@Parcelize
data class HeroStories(
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<HeroStoriesItem> = emptyList(),
    val returned: Int = 0
) : Parcelable

@Parcelize
data class HeroStoriesItem(
    val resourceURI: String = "",
    val name: String = "",
    val type: String = ""
) : Parcelable

@Parcelize
data class HeroEvents(
    val available: Int = 0,
    val collectionURI: String = "",
    val items: List<HeroEventsItem> = emptyList(),
    val returned: Int = 0
) : Parcelable

@Parcelize
data class HeroEventsItem(
    val resourceURI: String = "",
    val name: String = "",
    val type: String = ""
) : Parcelable

@Parcelize
data class HeroUrl(
    val type: String = "",
    val url: String = ""
) : Parcelable

data class LoadPage(
    val nowPage: Int,
    val totalPage: Int
)
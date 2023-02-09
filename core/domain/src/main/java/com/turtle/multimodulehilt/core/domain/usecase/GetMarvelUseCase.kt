package com.turtle.multimodulehilt.core.domain.usecase

import com.turtle.multimodulehilt.core.data.MarvelRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMarvelUseCase @Inject constructor(
    private val repository: MarvelRepository
) {

    fun getHero() = repository.getHeroes()

    fun getComicById(id: Int) = repository.getComics(id = id)

}
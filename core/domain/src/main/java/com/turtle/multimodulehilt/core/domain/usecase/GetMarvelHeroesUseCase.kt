package com.turtle.multimodulehilt.core.domain.usecase

import com.turtle.multimodulehilt.core.data.MarvelRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetMarvelHeroesUseCase @Inject constructor(
    private val repository: MarvelRepository
) {

    operator fun invoke() = repository.getHeroes()

}
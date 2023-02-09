package com.turtle.multimodulehilt.core.data

import com.turtle.multimodulehilt.core.model.CharacterDataWrapper
import com.turtle.multimodulehilt.core.model.ComicDataWrapper
import io.reactivex.rxjava3.core.Single

interface MarvelRepository {

    fun getHeroes(): Single<CharacterDataWrapper>

    fun getComics(id: Int): Single<ComicDataWrapper>
}
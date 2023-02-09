package com.turtle.multimodulehilt.core.data

import com.turtle.multimodulehilt.core.common.handleNetworkException
import com.turtle.multimodulehilt.core.data.mapper.ComicMapper.toDomainModel
import com.turtle.multimodulehilt.core.data.mapper.HeroMapper.toDomainModel
import com.turtle.multimodulehilt.core.model.CharacterDataWrapper
import com.turtle.multimodulehilt.core.model.ComicDataWrapper
import com.turtle.multimodulehilt.core.network.MarvelDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val source: MarvelDataSource,
) : MarvelRepository {

    override fun getHeroes(): Single<CharacterDataWrapper> {
        return source.getHeroes()
            .handleNetworkException()
            .flatMap { response ->
                val characterDataWrapperEntity = response.body()!!
                return@flatMap Single.just(characterDataWrapperEntity.toDomainModel())
            }
    }

    override fun getComics(id: Int): Single<ComicDataWrapper> {
        return source.getComics(id = id)
            .handleNetworkException()
            .flatMap { response ->
                val comicDataWrapperEntity = response.body()!!
                return@flatMap Single.just(comicDataWrapperEntity.toDomainModel())
            }
    }

}
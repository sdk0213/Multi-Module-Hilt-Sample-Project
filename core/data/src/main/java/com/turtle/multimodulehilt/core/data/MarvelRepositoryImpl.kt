package com.turtle.multimodulehilt.core.data

import com.turtle.multimodulehilt.core.common.handleNetworkException
import com.turtle.multimodulehilt.core.data.mapper.HeroMapper.toDomainModel
import com.turtle.multimodulehilt.core.model.HeroJsonBody
import com.turtle.multimodulehilt.core.network.MarvelDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val source: MarvelDataSource,
) : MarvelRepository {

    override fun getHeroes(): Single<HeroJsonBody> {
        return source.getHeroes()
            .handleNetworkException()
            .flatMap { response ->
                val heroJsonBodyEntity = response.body()!!
                return@flatMap Single.just(heroJsonBodyEntity.toDomainModel())
            }
    }

}
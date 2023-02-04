package com.turtle.multimodulehilt.core.data

import com.turtle.multimodulehilt.core.model.HeroJsonBody
import io.reactivex.rxjava3.core.Single

interface MarvelRepository {

    fun getHeroes(): Single<HeroJsonBody>
}
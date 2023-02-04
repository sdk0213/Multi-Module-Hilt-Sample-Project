package com.turtle.multimodulehilt.core.data.di

import com.turtle.multimodulehilt.core.data.MarvelRepository
import com.turtle.multimodulehilt.core.data.MarvelRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindMarvelRepository(marvelRepositoryImpl: MarvelRepositoryImpl): MarvelRepository

}
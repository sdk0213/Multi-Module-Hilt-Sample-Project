package com.turtle.multimodulehilt.core.data.mapper

import com.turtle.multimodulehilt.core.model.CharacterDataContainer
import com.turtle.multimodulehilt.core.model.CharacterDataWrapper
import com.turtle.multimodulehilt.core.network.model.CharacterDataContainerEntity
import com.turtle.multimodulehilt.core.network.model.CharacterDataWrapperEntity

object HeroMapper : Mapper<CharacterDataWrapperEntity, CharacterDataWrapper> {

    override fun CharacterDataWrapperEntity.toDomainModel(): CharacterDataWrapper {
        return CharacterDataWrapper(
            CharacterDataContainer(
                data.offset,
                data.limit,
                data.total,
                data.count,
                data.results
            )
        )
    }

    override fun CharacterDataWrapper.toExternalModel(): CharacterDataWrapperEntity {
        return CharacterDataWrapperEntity(
            CharacterDataContainerEntity(
                data.offset,
                data.limit,
                data.total,
                data.count,
                data.results
            )
        )
    }

}

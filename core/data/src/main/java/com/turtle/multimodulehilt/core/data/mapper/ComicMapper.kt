package com.turtle.multimodulehilt.core.data.mapper

import com.turtle.multimodulehilt.core.model.ComicDataContainer
import com.turtle.multimodulehilt.core.model.ComicDataWrapper
import com.turtle.multimodulehilt.core.network.model.ComicDataContainerEntity
import com.turtle.multimodulehilt.core.network.model.ComicDataWrapperEntity

object ComicMapper : Mapper<ComicDataWrapperEntity, ComicDataWrapper> {

    override fun ComicDataWrapperEntity.toDomainModel(): ComicDataWrapper {
        return ComicDataWrapper(
            ComicDataContainer(
                data.offset,
                data.limit,
                data.total,
                data.count,
                data.results
            )
        )
    }

    override fun ComicDataWrapper.toExternalModel(): ComicDataWrapperEntity {
        return ComicDataWrapperEntity(
            ComicDataContainerEntity(
                data.offset,
                data.limit,
                data.total,
                data.count,
                data.results
            )
        )
    }

}

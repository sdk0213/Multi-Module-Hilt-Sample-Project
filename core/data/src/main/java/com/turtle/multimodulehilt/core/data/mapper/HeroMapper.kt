package com.turtle.multimodulehilt.core.data.mapper

import com.turtle.multimodulehilt.core.model.HeroJsonBody
import com.turtle.multimodulehilt.core.model.HeroJsonDataBody
import com.turtle.multimodulehilt.core.network.model.HeroJsonBodyEntity
import com.turtle.multimodulehilt.core.network.model.HeroJsonDataBodyEntity

object HeroMapper : Mapper<HeroJsonBodyEntity, HeroJsonBody> {

    override fun HeroJsonBodyEntity.toDomainModel(): HeroJsonBody {
        return HeroJsonBody(code, status, copyright, attributionText, attributionHTML, etag, HeroJsonDataBody(data.offset, data.limit, data.total, data.count, data.results))
    }

    override fun HeroJsonBody.toExternalModel(): HeroJsonBodyEntity {
        return HeroJsonBodyEntity(code, status, copyright, attributionText, attributionHTML, etag, HeroJsonDataBodyEntity(data.offset, data.limit, data.total, data.count, data.results))
    }

}

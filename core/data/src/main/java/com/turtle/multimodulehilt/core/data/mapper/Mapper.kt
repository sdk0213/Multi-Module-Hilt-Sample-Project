package com.turtle.multimodulehilt.core.data.mapper

interface Mapper<ExternalModel, DomainModel> {
    fun ExternalModel.toDomainModel(): DomainModel
    fun DomainModel.toExternalModel(): ExternalModel
}
package com.turtle.multimodulehilt.core.network

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton
import com.turtle.multimodulehilt.core.network.model.HeroJsonBodyEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

private interface MarvelService {

    // 마블 영웅 가져오기
    @GET("characters")
    fun getHeroList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
        @Query("ts") ts: Long,
        @Query("apikey") serviceKey: String = MARVEL_PUBLIC_KEY,
        @Query("hash") hash: String
    ): Single<Response<HeroJsonBodyEntity>>

    companion object {
        // Marvel API 공용키
        const val MARVEL_PUBLIC_KEY =
            "5bad67907a373dfe612108031226807a"

        // Marvel API 개인키
        const val MARVEL_PRIVATE_KEY = "20be43097d02499d9c5a539cc6ff164125b46ce5" // BuildConfig 로 변경
    }

}

@Singleton
class MarvelNetwork @Inject constructor(
    @Named("marvel") private val retrofitBuilder: Retrofit
) : MarvelDataSource {

    private val retrofit by lazy {
        retrofitBuilder.create(MarvelService::class.java)
    }

    override fun getHeroes() : Single<Response<HeroJsonBodyEntity>> {
        val now = Date().time
        val hash = md5(now.toString() +  MarvelService.MARVEL_PRIVATE_KEY + MarvelService.MARVEL_PUBLIC_KEY)
        return retrofit.getHeroList(ts = now, hash = hash)
    }
}

fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}
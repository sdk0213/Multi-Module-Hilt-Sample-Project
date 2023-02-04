package com.turtle.multimodulehilt.core.network.di

import com.turtle.multimodulehilt.core.network.MarvelDataSource
import com.turtle.multimodulehilt.core.network.MarvelNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named("marvel")
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .build()
    }

    @Singleton
    @Provides
    @Named("marvel")
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(40, TimeUnit.SECONDS)  // 커넥션 타임아웃
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Singleton
    @Provides
    @Named("marvel")
    fun provideLogginInterceptor(): HttpLoggingInterceptor { // todo: Timber 삽입 필요
        return HttpLoggingInterceptor {
//            Timber.d("Http Logging message : $message")
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

}

@Module
@InstallIn(SingletonComponent::class)
interface NetworkBindModule {

    @Binds
    @Singleton
    fun bindMarvelNetwork(marvelNetwork: MarvelNetwork): MarvelDataSource
}
package com.seisekulov.rickandmorty.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.seisekulov.rickandmorty.BuildConfig
import com.seisekulov.rickandmorty.model.CharacterStatus
import com.seisekulov.rickandmorty.model.Gender
import com.seisekulov.rickandmorty.network.adapter.CharacterStatusTypeAdapter
import com.seisekulov.rickandmorty.network.adapter.DateTypeAdapter
import com.seisekulov.rickandmorty.network.adapter.GenderTypeAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Date::class.java, DateTypeAdapter())
            .registerTypeAdapter(Gender::class.java, GenderTypeAdapter())
            .registerTypeAdapter(CharacterStatus::class.java, CharacterStatusTypeAdapter())
            .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

}
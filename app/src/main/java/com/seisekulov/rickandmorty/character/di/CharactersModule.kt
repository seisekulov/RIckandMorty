package com.seisekulov.rickandmorty.character.di

import com.seisekulov.rickandmorty.character.data.CharacterRepository
import com.seisekulov.rickandmorty.character.data.CharacterRepositoryImpl
import com.seisekulov.rickandmorty.character.data.remote.CharacterApi
import com.seisekulov.rickandmorty.character.data.remote.CharacterRemoteDatasource
import com.seisekulov.rickandmorty.character.data.remote.CharacterRemoteDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CharactersModule {

    @Binds
    abstract fun bindCharacterRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository

    @Binds
    abstract fun bindRemoteDatasource(
        characterRemoteDatasourceImpl: CharacterRemoteDatasourceImpl,
    ): CharacterRemoteDatasource

    companion object {

        @Provides
        @Singleton
        fun provideCharactersApi(retrofit: Retrofit): CharacterApi {
            return retrofit.create(CharacterApi::class.java)
        }
    }

}
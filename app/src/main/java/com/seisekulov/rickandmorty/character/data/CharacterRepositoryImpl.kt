package com.seisekulov.rickandmorty.character.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.seisekulov.rickandmorty.character.data.remote.CharacterRemoteDataSource
import com.seisekulov.rickandmorty.character.model.Character
import com.seisekulov.rickandmorty.model.CharacterStatus
import com.seisekulov.rickandmorty.model.Gender
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {
    override val charactersCount: LiveData<Int>
        get() = characterRemoteDataSource.charactersCount

    override fun getAsPagingData(
        name: String?,
        status: CharacterStatus?,
        gender: Gender?
    ): LiveData<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = DEFAULT_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSource(
                    characterRemoteDataSource = characterRemoteDataSource,
                    name = name,
                    status = status,
                    gender = gender
                )
            }
        ).liveData
    }

    override suspend fun getCharacters(): List<Character> {
        return emptyList()
    }

    companion object {

        private const val DEFAULT_PAGE_SIZE = 20
    }
}
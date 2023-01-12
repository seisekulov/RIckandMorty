package com.seisekulov.rickandmorty.character.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.seisekulov.rickandmorty.character.data.remote.CharacterRemoteDataSource
import com.seisekulov.rickandmorty.character.model.Character
import com.seisekulov.rickandmorty.model.CharacterStatus
import com.seisekulov.rickandmorty.model.Gender
import retrofit2.HttpException
import java.io.IOException

internal class CharacterPagingSource(
    private val characterRemoteDataSource: CharacterRemoteDataSource,
    private val name: String? = null,
    private val status: CharacterStatus? = null,
    private val gender: Gender? = null
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val characters = characterRemoteDataSource.getCharacters(
                page = page,
                name = name,
                status = status,
                gender = gender
            )

            LoadResult.Page(
                data = characters,
                prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (characters.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    companion object {

        private const val DEFAULT_PAGE_INDEX = 1
    }
}
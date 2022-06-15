package com.example.burotoapp.data.repository

import androidx.paging.PagingData
import com.example.burotoapp.domain.model.Hero
import com.example.burotoapp.domain.repository.DataStoreOperations
import com.example.burotoapp.domain.repository.LocalDataSource
import com.example.burotoapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor (
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
    ) {

    fun getAllHeroes() : Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String) : Flow<PagingData<Hero>> {
        return remote.searchHeroes(query = query)
    }

    suspend fun getSelectedHero(heroId: Int): Hero {
        return local.getSelectedHero(heroId = heroId)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnboardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnboardingState()
    }
}
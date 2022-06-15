package com.example.burotoapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.example.burotoapp.data.repository.Repository
import com.example.burotoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query)
    }
}
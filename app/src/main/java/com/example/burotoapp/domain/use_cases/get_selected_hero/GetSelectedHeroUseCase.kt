package com.example.burotoapp.domain.use_cases.get_selected_hero

import com.example.burotoapp.data.repository.Repository
import com.example.burotoapp.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId = heroId)
    }
}
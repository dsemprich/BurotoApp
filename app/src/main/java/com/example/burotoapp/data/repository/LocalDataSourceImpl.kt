package com.example.burotoapp.data.repository

import com.example.burotoapp.data.local.BorutoDatabase
import com.example.burotoapp.domain.model.Hero
import com.example.burotoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    borutoDatabase: BorutoDatabase
): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}
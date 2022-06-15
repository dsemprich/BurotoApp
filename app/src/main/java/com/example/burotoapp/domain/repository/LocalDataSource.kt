package com.example.burotoapp.domain.repository

import com.example.burotoapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}
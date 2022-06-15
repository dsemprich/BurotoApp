package com.example.burotoapp.data.remote

import com.example.burotoapp.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {

    @GET("/api/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/api/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse

}
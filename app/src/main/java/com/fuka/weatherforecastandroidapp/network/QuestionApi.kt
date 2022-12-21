package com.fuka.weatherforecastandroidapp.network

import com.fuka.weatherforecastandroidapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

// This class can be compared with DAO

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}
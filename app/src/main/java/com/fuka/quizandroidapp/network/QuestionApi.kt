package com.fuka.quizandroidapp.network

import com.fuka.quizandroidapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

// This class can be compared with DAO

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): Question
}
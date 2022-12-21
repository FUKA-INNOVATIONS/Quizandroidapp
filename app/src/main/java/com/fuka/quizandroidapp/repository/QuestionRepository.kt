package com.fuka.quizandroidapp.repository

import android.util.Log
import com.fuka.quizandroidapp.data.DataOrException
import com.fuka.quizandroidapp.model.QuestionItem
import com.fuka.quizandroidapp.network.QuestionApi
import com.fuka.quizandroidapp.util.Constants
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {

    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d(Constants.LOG_TAG, "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

}
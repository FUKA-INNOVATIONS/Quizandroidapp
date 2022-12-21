package com.fuka.weatherforecastandroidapp.repository

import android.util.Log
import com.fuka.weatherforecastandroidapp.data.DataOrException
import com.fuka.weatherforecastandroidapp.model.QuestionItem
import com.fuka.weatherforecastandroidapp.network.QuestionApi
import com.fuka.weatherforecastandroidapp.util.Constants
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
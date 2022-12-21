package com.fuka.quizandroidapp.component

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.fuka.quizandroidapp.util.Constants
import com.fuka.quizandroidapp.viewModel.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {

    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading ==  true) {
        CircularProgressIndicator()
        Log.d(Constants.LOG_TAG, "Questions: Loading..")
    } else {
        Log.d(Constants.LOG_TAG, "Questions: Loading Stopped")
        questions?.forEach { questionItem ->
            // Log.d(Constants.LOG_TAG, "Question: ${questionItem.question}")
        }
    }

    Log.d(Constants.LOG_TAG, "Questions: ${questions?.size}")

}
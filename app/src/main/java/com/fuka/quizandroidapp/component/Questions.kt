package com.fuka.quizandroidapp.component

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.fuka.quizandroidapp.util.Constants
import com.fuka.quizandroidapp.viewModel.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {

    val questions = viewModel.data.value.data?.toMutableList()

    val questionIndex = remember {
        mutableStateOf(0)
    }

    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
    } else {

        val question = try {
            questions?.get(questionIndex.value)
        } catch (ex: Exception) { null }

        if (questions != null) {
            QuestionDisplay(question = question!!, questionIndex = questionIndex, viewModel = viewModel) {
                questionIndex.value = questionIndex.value + 1
            }
        }
    }

    Log.d(Constants.LOG_TAG, "Questions: ${questions?.size}")

}



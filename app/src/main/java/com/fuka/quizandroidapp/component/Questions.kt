package com.fuka.quizandroidapp.component

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fuka.quizandroidapp.ui.AppColors
import com.fuka.quizandroidapp.util.Constants
import com.fuka.quizandroidapp.viewModel.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {

    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == true) {
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



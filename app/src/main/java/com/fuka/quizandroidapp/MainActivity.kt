package com.fuka.quizandroidapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.fuka.quizandroidapp.ui.theme.QuizAndroidAppTheme
import com.fuka.quizandroidapp.util.Constants
import com.fuka.quizandroidapp.viewModel.QuestionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAndroidAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    QuestionHome()

                }
            }
        }
    }
}

@Composable
fun QuestionHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    Questions(viewModel)
}

@Composable
fun Questions(viewModel: QuestionsViewModel) {

    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading ==  true) {
        Log.d(Constants.LOG_TAG, "Questions: Loading..")
    } else {
        Log.d(Constants.LOG_TAG, "Questions: Loading Stopped")
        questions?.forEach { questionItem ->
            Log.d(Constants.LOG_TAG, "Question: ${questionItem.question}")
        }
    }

    Log.d(Constants.LOG_TAG, "Questions: ${questions?.size}")

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizAndroidAppTheme {

    }
}
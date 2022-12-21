package com.fuka.quizandroidapp.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.fuka.quizandroidapp.component.Questions
import com.fuka.quizandroidapp.viewModel.QuestionsViewModel

@Composable
fun QuizHome(viewModel: QuestionsViewModel = hiltViewModel()) {
    Questions(viewModel)
}
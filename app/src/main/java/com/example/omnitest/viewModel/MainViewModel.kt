package com.example.omnitest.viewModel

import androidx.lifecycle.viewModelScope
import com.example.omnitest.api.ApiResultWrapper
import com.example.omnitest.api.NewsRepository
import com.example.omnitest.model.NewsModel
import com.example.omnitest.utils.UiState
import com.utopiagame.viewmodel.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */
class MainViewModel(private val newsRepository: NewsRepository): BaseViewModel() {
    val state = viewModelStateFlow<UiState>(UiState.Init)
    val newsModel = viewModelStateFlow(NewsModel())

    fun getNews() {
        state.mutable = UiState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            val result = newsRepository.getNews()
            state.mutable = when(result) {
                is ApiResultWrapper.Success -> {
                    newsModel.mutable = result.value
                    UiState.Success(result.value)
                }
                is ApiResultWrapper.GenericError ->  UiState.Error("Error during network call", "Code: ${result.code} Message: ${result.message}")
                else -> UiState.Error("Network Error", "An unknown error occurred, please check your internet connection and try again.")
            }
        }
    }
}
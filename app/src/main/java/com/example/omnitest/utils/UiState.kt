package com.example.omnitest.utils

import com.example.omnitest.model.NewsModel

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */
sealed class UiState {
    object Init: UiState()
    object Loading: UiState()
    data class Success(val news: NewsModel): UiState()
    data class Error(val title: String, val desc: String): UiState()
}
package com.example.omnitest.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.omnitest.model.NewsItem
import com.example.omnitest.utils.LocalMainVM
import com.example.omnitest.utils.OmniTextStyle
import com.example.omnitest.utils.UiState
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */

@Composable
fun MainScreen() {
    val vm = LocalMainVM.current
    val state by vm.state.collectAsState()

    when(state) {
        is UiState.Init -> vm.getNews()
        is UiState.Loading -> LoadingScreen()
        is UiState.Success -> MainContentScreen()
        is UiState.Error -> ErrorScreen(title = (state as UiState.Error).title, desc = (state as UiState.Error).desc) {
            vm.getNews()
        }
    }
}

@Composable
private fun MainContentScreen() {
    val vm = LocalMainVM.current
    val newsModel by vm.newsModel.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(count = newsModel.itemList.size) {index ->
            val item = newsModel.itemList[index]

            when (index) {
                0 -> BigNewsItem(item = item)
                1, 2 -> MediumNewsItem(item = item)
                3, 4 -> OmniMoreItem(item = item)
                else -> OmniFavoriteItem(item = item)
            }
        }
    }
}


package com.example.omnitest

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.omnitest.screen.MainScreen
import com.example.omnitest.utils.LocalMainVM
import com.example.omnitest.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */
class MainActivity: ComponentActivity() {
    private val mMainViewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            ) {
                CompositionLocalProvider(
                    LocalMainVM provides mMainViewModel
                ) {
                    MainScreen()
                }
            }
        }
    }
}
package com.example.omnitest.module

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.omnitest.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */


val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
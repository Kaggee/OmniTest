package com.example.omnitest.utils

import androidx.compose.runtime.compositionLocalOf
import com.example.omnitest.viewModel.MainViewModel

/**
 * Created on 2023-02-17.
 * Copyrightâ’¸ Kagge
 */


val LocalMainVM = compositionLocalOf<MainViewModel> { error("No MainViewModel Found!") }
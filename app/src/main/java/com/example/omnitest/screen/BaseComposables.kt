package com.example.omnitest.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.omnitest.R
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */


@Composable
fun OmniButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.padding(top = 8.dp),
        onClick = onClick,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = buttonText)
    }
}

@Composable
fun NewsImage(
    modifier: Modifier = Modifier,
    url: String?
) {
    GlideImage(
        modifier = modifier,
        imageModel = {
            url?.replace("http://", "https://") ?: ""
        },
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        ),
        loading = {
            LoadingScreen()
        }
    )
}
package com.example.omnitest.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.omnitest.R
import com.example.omnitest.utils.OmniTextStyle

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */

@Composable
fun LoadingScreen(
modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading))
        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )

        LottieAnimation(
            modifier = Modifier
                .requiredSize(200.dp, 200.dp)
                .align(Alignment.Center),
            composition = composition,
            progress = progress
        )
    }
}


@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    onRetry: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                modifier = Modifier.fillMaxWidth(),
                style = OmniTextStyle.getBigText(),
                textAlign = TextAlign.Center
            )

            Text(
                desc,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                style = OmniTextStyle.getMedText(),
                textAlign = TextAlign.Center
            )

            OmniButton(
                modifier = Modifier.width(150.dp),
                buttonText = "Try Again"
            ) {
                onRetry()
            }
        }
    }
}
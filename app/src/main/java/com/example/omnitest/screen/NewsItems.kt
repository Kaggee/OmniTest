package com.example.omnitest.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.omnitest.model.NewsItem
import com.example.omnitest.utils.OmniTextStyle
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import com.example.omnitest.R
import com.example.omnitest.utils.Colors

/**
 * Created on 2023-02-18.
 * CopyrightⒸ Kagge
 */


@Composable
fun MediumNewsItem(item: NewsItem) {
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(start = 8.dp, end = 8.dp)
    ) {
        val (title, desc, image, date, divider) = createRefs()

        Text(
            modifier = Modifier.constrainAs(title) {
                start.linkTo(parent.start)
                top.linkTo(parent.top, 8.dp)
                end.linkTo(image.start, 8.dp)
                width = Dimension.fillToConstraints
            },
            text = item.newsTitle,
            style = OmniTextStyle.getBigText(bold = true)
        )

        Text(
            modifier = Modifier.constrainAs(desc) {
                start.linkTo(parent.start)
                top.linkTo(title.bottom, 4.dp)
                end.linkTo(image.start, 8.dp)
                width = Dimension.fillToConstraints
            },
            text = item.newsDescription,
            style = OmniTextStyle.getMedText(),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

        NewsImage(
            modifier = Modifier.constrainAs(image) {
                top.linkTo(title.top)
                end.linkTo(parent.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            },
            url = item.newsImage?.url?.replace("http://", "https://")
        )

        Text(
            modifier = Modifier.constrainAs(date) {
                top.linkTo(desc.bottom, 4.dp)
                start.linkTo(parent.start)
                end.linkTo(image.start, 8.dp)
                width = Dimension.fillToConstraints
            },
            text = item.publishDate,
            style = OmniTextStyle.getSmallText()
        )

        Box(
            modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(date.bottom, 8.dp)
                    bottom.linkTo(parent.bottom, 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(1.dp)
                }
                .height(1.dp)
                .background(Color.LightGray)
        )
    }
}

@Composable
fun BigNewsItem(item: NewsItem) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(start = 8.dp, end = 8.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        NewsImage(
            modifier = Modifier.fillMaxWidth(),
            url = item.newsImage?.url?.replace("http://", "https://")
        )

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.newsTitle,
            style = OmniTextStyle.getBigText(bold = true)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.newsDescription,
            style = OmniTextStyle.getMedText(),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.publishDate,
            style = OmniTextStyle.getSmallText()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
    }
}

@Composable
fun OmniMoreItem(item: NewsItem) {
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(start = 8.dp, end = 8.dp)
    ) {
        val (title, image, omniMore, divider) = createRefs()

        Text(
            modifier = Modifier.constrainAs(title) {
                start.linkTo(parent.start)
                top.linkTo(parent.top, 8.dp)
                end.linkTo(image.start, 8.dp)
                width = Dimension.fillToConstraints
            },
            text = item.newsTitle,
            style = OmniTextStyle.getBigText(bold = true)
        )

        NewsImage(
            modifier = Modifier.constrainAs(image) {
                top.linkTo(title.top)
                end.linkTo(parent.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            },
            url = item.newsImage?.url?.replace("http://", "https://")
        )

        Text(
            modifier = Modifier.constrainAs(omniMore) {
                start.linkTo(parent.start)
                bottom.linkTo(image.bottom)
                width = Dimension.fillToConstraints
            },
            text = stringResource(id = R.string.omni_more),
            style = OmniTextStyle.getSmallText(color = Colors.orange, bold = true),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

        Box(
            modifier = Modifier
                .constrainAs(divider) {
                    top.linkTo(omniMore.bottom, 8.dp)
                    bottom.linkTo(parent.bottom, 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.value(1.dp)
                }
                .height(1.dp)
                .background(Color.LightGray)
        )
    }
}

@Composable
fun OmniFavoriteItem(item: NewsItem) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(start = 8.dp, end = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        NewsImage(
            modifier = Modifier
                .requiredSize(100.dp)
                .padding(vertical = 8.dp),
            url = item.newsImage?.url?.replace("http://", "https://")
        )

        Text(
            modifier = Modifier.width(200.dp),
            text = item.newsTitle,
            style = OmniTextStyle.getMedText(color = Colors.favGreen, bold = true)
        )

        Icon(
            Icons.Outlined.Star,
            modifier = Modifier.padding(end = 8.dp),
            contentDescription = "",
            tint = Colors.favGreen
        )
    }
}
package com.example.omnitest.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */
object OmniTextStyle {
    fun getBigText(color: Color = Color.Black, bold: Boolean = false): TextStyle =
        TextStyle(
            color = color,
            fontSize = 20.sp,
            fontWeight = if(bold) FontWeight.Bold else null
        )

    fun getMedText(color: Color = Color.Black, bold: Boolean = false): TextStyle =
        TextStyle(
            color = color,
            fontSize = 16.sp,
            fontWeight = if(bold) FontWeight.Bold else null
        )

    fun getSmallText(color: Color = Color.Black, bold: Boolean = false): TextStyle =
        TextStyle(
            color = color,
            fontSize = 12.sp,
            fontWeight = if(bold) FontWeight.Bold else null
        )
}
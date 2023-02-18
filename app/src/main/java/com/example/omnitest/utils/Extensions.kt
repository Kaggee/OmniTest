package com.example.omnitest.utils

import android.util.Log

/**
 * Created on 2023-02-17.
 * CopyrightⒸ Kagge
 */


fun String.log() {
    Log.d("OmniTestLog", this)
}

fun Throwable.logError() {
    Log.w("OmniTestLog", this)
}
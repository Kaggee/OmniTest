package com.utopiagame.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Copied (Without shame) from Vini @ H&M
 */

// region - ViewModelStateFlow
sealed class ViewModelStateFlow<T>(flow: StateFlow<T>) : StateFlow<T> by flow

private class ViewModelStateFlowImpl<T>(
    initial: T,
    val wrapped: MutableStateFlow<T> = MutableStateFlow(initial)
) : ViewModelStateFlow<T>(wrapped)
// endregion

// region - ViewModelSharedFlow
sealed class ViewModelSharedFlow<T>(flow: SharedFlow<T>) : SharedFlow<T> by flow

private class ViewModelSharedFlowImpl<T>(
    replay: Int,
    extraBufferCapacity: Int,
    onBufferOverflow: BufferOverflow,
    val wrapped: MutableSharedFlow<T> = MutableSharedFlow(replay, extraBufferCapacity, onBufferOverflow)
) : ViewModelSharedFlow<T>(wrapped)
// endregion

open class BaseViewModel : ViewModel() {
    // region - ViewModelStateFlow
    protected fun <T> viewModelStateFlow(initial: T): ViewModelStateFlow<T> = ViewModelStateFlowImpl(initial)

    protected suspend fun <T> ViewModelStateFlow<T>.emit(value: T) = when (this) {
        is ViewModelStateFlowImpl -> wrapped.emit(value)
    }

    protected var <T> ViewModelStateFlow<T>.mutable: T
        get() = when (this) {
            is ViewModelStateFlowImpl -> wrapped.value
        }
        set(value) = when (this) {
            is ViewModelStateFlowImpl -> wrapped.value = value
        }
    // endregion

    // region - ViewModelSharedFlow
    protected fun <T> viewModelSharedFlow(
        replay: Int = 0,
        extraBufferCapacity: Int = 0,
        onBufferOverflow: BufferOverflow = BufferOverflow.SUSPEND,
    ): ViewModelSharedFlow<T> = ViewModelSharedFlowImpl(replay, extraBufferCapacity, onBufferOverflow)

    protected suspend fun <T> ViewModelSharedFlow<T>.emit(value: T) = when (this) {
        is ViewModelSharedFlowImpl -> wrapped.emit(value)
    }

    protected fun <T> ViewModelSharedFlow<T>.tryEmit(value: T) = when (this) {
        is ViewModelSharedFlowImpl -> wrapped.tryEmit(value)
    }
    // endregion
}
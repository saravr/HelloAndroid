package com.sandymist.helloandroid.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HelloViewModel @Inject constructor(): ViewModel() {
    val name = MutableStateFlow("Android")
    private var counter = 0

    init {
        Timber.e("++++ HelloViewModel is created")
        viewModelScope.launch {
            repeat(1000) {
                delay(1000)
                ++counter
                name.emit("Android $counter")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.e("++++ HelloViewModel is cleared")
    }
}

package com.example.ucbexamenes.features.time.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.ucbexamenes.features.time.domain.usecase.GetServerTimeUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
class TimeViewModel(
    private val useCase: GetServerTimeUseCase
) : ViewModel() {

    private val _time = MutableStateFlow("Cargando...")
    val time: StateFlow<String> = _time

    init {
        viewModelScope.launch {
            while (true) {
                _time.value = useCase()
                delay(1000)
            }
        }
    }
}

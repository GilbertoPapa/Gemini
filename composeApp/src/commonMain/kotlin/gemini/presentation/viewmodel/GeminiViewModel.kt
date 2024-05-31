package gemini.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import gemini.domain.usecase.GeminiUseCase
import gemini.domain.usecase.KeyUseCase
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class GeminiViewModel(
    private val geminiUseCase: GeminiUseCase,
    private val keyUseCase: KeyUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _geminiState = MutableStateFlow<GeminiState>(GeminiState.Empty)
    val geminiState = _geminiState.asStateFlow()

    fun postPrompt(seed: String) {
        viewModelScope.launch {
            geminiUseCase.invoke(seed = seed, key = getKey())
                .flowOn(dispatcher)
                .onStart { _geminiState.value = GeminiState.Loading }
                .catch { onError(it) }
                .collect { onSuccess(it.description) }
        }
    }

    private suspend fun getKey() =
        withContext(dispatcher) {
            keyUseCase.invoke()
        }


    private fun onSuccess(description: String) {
        _geminiState.value = GeminiState.ShowDescription(description)
    }

    private fun onError(throwable: Throwable) {
        _geminiState.value = GeminiState.ShowError
        trackingEngineer(throwable)
    }

    private fun trackingEngineer(throwable: Throwable) {
        println(throwable.stackTraceToString())
    }
}
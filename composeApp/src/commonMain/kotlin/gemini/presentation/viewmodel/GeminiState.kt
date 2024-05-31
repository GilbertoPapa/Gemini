package gemini.presentation.viewmodel

sealed class GeminiState {
    data object Empty : GeminiState()
    data object Loading : GeminiState()
    data class ShowDescription(val description: String) : GeminiState()
    data object ShowError : GeminiState()
}
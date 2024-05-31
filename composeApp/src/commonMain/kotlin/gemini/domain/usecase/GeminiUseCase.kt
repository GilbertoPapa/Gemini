package gemini.domain.usecase

import gemini.domain.repository.GeminiRepository

class GeminiUseCase(
    private val geminiRepository: GeminiRepository
) {
    operator fun invoke(seed: String) = geminiRepository.postPromptGemini(seed = seed)
}
package gemini.domain.usecase

import gemini.domain.repository.KeyRepository

class KeyUseCase(
    private val keyRepository: KeyRepository
) {
    suspend operator fun invoke(): String = keyRepository.getKey()
}
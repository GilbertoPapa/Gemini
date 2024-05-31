package gemini.domain.repository

import kotlinx.coroutines.flow.Flow
import gemini.domain.model.GeminiDTO

interface GeminiRepository {
    fun postPromptGemini(seed: String): Flow<GeminiDTO>
}
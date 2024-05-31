package gemini.data.datasource

import kotlinx.coroutines.flow.Flow
import gemini.data.model.GeminiRequest
import gemini.data.model.GeminiResponse

interface GeminiDataSource {
    fun postPromptGemini(request: GeminiRequest) : Flow<GeminiResponse>
}
package gemini.data.datasource.remote

import kotlinx.coroutines.flow.Flow
import gemini.data.model.GeminiRequest
import gemini.data.model.GeminiResponse

interface GeminiDataSource {
    fun postPromptGemini(request: GeminiRequest, key: String) : Flow<GeminiResponse>
}
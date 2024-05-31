package gemini.data.datasource.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import gemini.data.service.GeminiService
import gemini.data.model.GeminiRequest
import gemini.data.model.GeminiResponse

class GeminiDataSourceImpl(
    private val geminiService: GeminiService
) : GeminiDataSource {
    override fun postPromptGemini(request: GeminiRequest, key: String): Flow<GeminiResponse> {
        return flow {
            val response = geminiService.postPromptGemini(
                body = request,
                key = key
            )
            emit(response)
        }
    }
}
package gemini.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import gemini.data.service.GeminiService
import gemini.data.keys.ServiceConstants
import gemini.data.model.GeminiRequest
import gemini.data.model.GeminiResponse

class GeminiDataSourceImpl(
    private val serviceConstants: ServiceConstants,
    private val geminiService: GeminiService
) : GeminiDataSource {
    override fun postPromptGemini(request: GeminiRequest): Flow<GeminiResponse> {
        return flow {
            val response = geminiService.postPromptGemini(
                request,
                serviceConstants.PARAM_GEMINI_KEY
            )
            emit(response)
        }
    }
}
package gemini.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import gemini.data.datasource.GeminiDataSource
import gemini.data.mapper.GeminiMapper
import gemini.domain.model.GeminiDTO
import gemini.domain.repository.GeminiRepository

class GeminiRepositoryImpl(
    private val geminiDataSource: GeminiDataSource,
    private val geminiMapper: GeminiMapper
) : GeminiRepository {
    override fun postPromptGemini(seed: String): Flow<GeminiDTO> {
        return geminiDataSource.postPromptGemini(geminiMapper.mapToSeed(seed = seed))
            .map { geminiMapper.mapToGeminiDTO(it) }
    }
}
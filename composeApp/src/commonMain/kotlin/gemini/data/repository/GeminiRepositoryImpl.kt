package gemini.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import gemini.data.datasource.remote.GeminiDataSource
import gemini.data.mapper.GeminiMapper
import gemini.domain.model.GeminiDTO
import gemini.domain.repository.GeminiRepository

class GeminiRepositoryImpl(
    private val geminiDataSource: GeminiDataSource,
    private val geminiMapper: GeminiMapper
) : GeminiRepository {
    override fun postPromptGemini(seed: String, key: String): Flow<GeminiDTO> {
        return geminiDataSource.postPromptGemini(
            request = geminiMapper.mapToSeed(seed = seed),
            key = key
        ).map { geminiMapper.mapToGeminiDTO(it) }
    }
}
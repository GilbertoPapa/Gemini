package gemini.data.mapper

import gemini.data.model.ContentRequest
import gemini.data.model.GeminiRequest
import gemini.data.model.PartRequest
import gemini.data.model.GeminiResponse
import gemini.domain.model.GeminiDTO

class GeminiMapper {
    fun mapToGeminiDTO(geminiResponse: GeminiResponse): GeminiDTO {
        return GeminiDTO(
            description = geminiResponse.candidates[0].content.parts[0].description
        )
    }

    fun mapToSeed(seed: String): GeminiRequest {
        return GeminiRequest(
            contents = listOf(
                ContentRequest(
                    parts = listOf(
                        PartRequest(
                            text = seed
                        )
                    )
                )
            )
        )
    }
}
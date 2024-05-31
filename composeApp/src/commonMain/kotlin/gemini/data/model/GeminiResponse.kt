package gemini.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeminiResponse(
    @SerialName("candidates")
    val candidates : List<CandidateResponse>
)

@Serializable
data class CandidateResponse(
    @SerialName("content")
    val content : ContentResponse
)

@Serializable
data class ContentResponse(
    @SerialName("parts")
    val parts : List<PartResponse>
)

@Serializable
data class PartResponse(
    @SerialName("text")
    val description : String
)
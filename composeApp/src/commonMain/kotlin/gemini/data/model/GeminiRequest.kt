package gemini.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GeminiRequest(
    val contents: List<ContentRequest>
)

@Serializable
data class ContentRequest(
    @SerialName("parts")
    val parts: List<PartRequest>
)

@Serializable
data class PartRequest(
    val text: String
)


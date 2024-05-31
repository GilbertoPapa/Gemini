package gemini.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Config(
    @SerialName("gemini_key")
    val geminiKey: String = ""
)
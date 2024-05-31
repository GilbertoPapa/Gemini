package gemini.domain.repository

interface KeyRepository {
    suspend fun getKey(): String
}
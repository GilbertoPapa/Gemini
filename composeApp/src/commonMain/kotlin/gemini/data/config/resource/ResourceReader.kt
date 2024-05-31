package gemini.data.config.resource

interface ResourceReader {
    suspend fun readResource(path: String): String
}
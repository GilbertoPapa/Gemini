package gemini.data.config.file

interface FileConfigProvider {
    suspend fun getKey(): String
}
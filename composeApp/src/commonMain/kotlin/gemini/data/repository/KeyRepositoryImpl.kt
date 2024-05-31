package gemini.data.repository

import gemini.data.config.file.FileConfigProvider
import gemini.domain.repository.KeyRepository

class KeyRepositoryImpl(
    private val fileConfigProvider: FileConfigProvider
): KeyRepository {
    override suspend fun getKey(): String {
        return fileConfigProvider.getKey()
    }
}
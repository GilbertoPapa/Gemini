package gemini.data.config.file

import gemini.data.config.parser.JsonParser
import gemini.data.config.resource.ResourceReader

class FileConfigProviderImpl(
    private val resourceReader: ResourceReader,
    private val jsonParser: JsonParser
) : FileConfigProvider {
    override suspend fun getKey(): String {
        return runCatching {
            val jsonString = resourceReader.readResource("files/config.json")
            jsonParser.parseConfig(jsonString).geminiKey
        }.getOrElse {
            it.printStackTrace()
            ""
        }
    }
}
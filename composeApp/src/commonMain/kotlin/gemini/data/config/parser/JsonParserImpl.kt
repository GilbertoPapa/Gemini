package gemini.data.config.parser

import gemini.data.model.Config
import kotlinx.serialization.json.Json

class JsonParserImpl : JsonParser {
    override fun parseConfig(jsonString: String): Config {
        return Json.decodeFromString(jsonString)
    }
}
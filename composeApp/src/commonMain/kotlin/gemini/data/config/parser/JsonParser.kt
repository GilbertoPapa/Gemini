package gemini.data.config.parser

import gemini.data.model.Config

interface JsonParser {
    fun parseConfig(jsonString: String): Config
}
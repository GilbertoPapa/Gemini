package gemini.data.config.resource

import gemini.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi


class ResourceReaderImpl : ResourceReader {
    @OptIn(ExperimentalResourceApi::class)
    override suspend fun readResource(path: String): String {
        return Res.readBytes(path).decodeToString()
    }
}
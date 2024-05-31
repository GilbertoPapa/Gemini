package gemini.di.provider

import common.data.config.ConfigClient.httpClient
import gemini.data.config.file.FileConfigProvider
import gemini.data.config.file.FileConfigProviderImpl
import gemini.data.config.parser.JsonParser
import gemini.data.config.parser.JsonParserImpl
import gemini.data.config.resource.ResourceReader
import gemini.data.config.resource.ResourceReaderImpl
import org.koin.dsl.module
import gemini.data.datasource.remote.GeminiDataSource
import gemini.data.datasource.remote.GeminiDataSourceImpl
import gemini.data.mapper.GeminiMapper
import gemini.data.repository.GeminiRepositoryImpl
import gemini.data.repository.KeyRepositoryImpl
import gemini.data.service.createGeminiService
import gemini.domain.repository.GeminiRepository
import gemini.domain.repository.KeyRepository
import gemini.domain.usecase.GeminiUseCase
import gemini.domain.usecase.KeyUseCase
import gemini.presentation.viewmodel.GeminiViewModel

object GeminiProvider {
    fun getModules() = geminiModule

    private val geminiModule = module {
        factory {
            httpClient.createGeminiService()
        }

        factory<GeminiDataSource> {
            GeminiDataSourceImpl(
                geminiService = get()
            )
        }
        factory<GeminiRepository> {
            GeminiRepositoryImpl(
                geminiDataSource = get(),
                geminiMapper = GeminiMapper()
            )
        }
        factory {
            GeminiUseCase(
                geminiRepository = get()
            )
        }
        factory {
            GeminiViewModel(
                geminiUseCase = get(),
                keyUseCase = get()
            )
        }

        factory<FileConfigProvider> {
            FileConfigProviderImpl(
                resourceReader = get(),
                jsonParser = get()
            )
        }

        factory<JsonParser> {
            JsonParserImpl()
        }

        factory<ResourceReader> {
            ResourceReaderImpl()
        }

        factory<KeyRepository> {
            KeyRepositoryImpl(
                fileConfigProvider = get()
            )
        }

        factory {
            KeyUseCase(
                keyRepository = get()
            )
        }
    }
}

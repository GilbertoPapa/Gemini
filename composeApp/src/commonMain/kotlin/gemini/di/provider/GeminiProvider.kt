package gemini.di.provider

import common.data.config.ConfigClient.httpClient
import org.koin.dsl.module
import gemini.data.datasource.GeminiDataSource
import gemini.data.datasource.GeminiDataSourceImpl
import gemini.data.keys.ServiceConstants
import gemini.data.mapper.GeminiMapper
import gemini.data.repository.GeminiRepositoryImpl
import gemini.data.service.createGeminiService
import gemini.domain.repository.GeminiRepository
import gemini.domain.usecase.GeminiUseCase
import gemini.presentation.viewmodel.GeminiViewModel

object GeminiProvider {
    fun getModules() = pictureModule

    private val pictureModule = module {
        factory {
            httpClient.createGeminiService()
        }

        factory<GeminiDataSource> {
            GeminiDataSourceImpl(
                serviceConstants = ServiceConstants,
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
                geminiUseCase = get()
            )
        }
    }
}

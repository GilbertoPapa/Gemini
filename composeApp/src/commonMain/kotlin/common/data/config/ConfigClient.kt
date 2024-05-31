package common.data.config

import common.data.config.ConfigClientConstants.BASE_URL
import common.data.config.ConfigClientConstants.LOG_MESSAGE
import common.data.config.ConfigClientConstants.RESPONSE_OBSERVER_MESSAGE
import common.data.config.ConfigClientConstants.TIMEOUT
import de.jensklingenberg.ktorfit.ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object ConfigClient {

    @OptIn(ExperimentalSerializationApi::class)
    val httpClient = ktorfit {
        baseUrl(BASE_URL)
        httpClient(
            HttpClient {
                expectSuccess = false
                install(HttpTimeout) {
                    val timeout = TIMEOUT
                    connectTimeoutMillis = timeout
                    requestTimeoutMillis = timeout
                    socketTimeoutMillis = timeout
                }

                install(ResponseObserver) {
                    onResponse { response ->
                        println("$RESPONSE_OBSERVER_MESSAGE${response.status.value}")
                    }
                }

                install(Logging) {
                    level = LogLevel.BODY

                    logger = object : Logger {
                        override fun log(message: String) {
                            println("$LOG_MESSAGE$message")
                        }
                    }
                }
                install(ContentNegotiation) {
                    json(Json {
                        explicitNulls = false
                        ignoreUnknownKeys = true
                        isLenient = true
                        prettyPrint = true
                        encodeDefaults = true
                    })
                }
            }
        )
    }
}
package com.itis.weather.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.plugins.api.SetupRequest
import io.ktor.client.plugins.api.createClientPlugin
import io.ktor.client.request.HttpRequestPipeline.Phases.Before
import io.ktor.util.AttributeKey

private const val API_KEY_NAME = "appid"
private const val UNITS_NAME = "units"

class ApiKeyPlugin {

    companion object Plugin : HttpClientPlugin<Unit, ApiKeyPlugin> {

        override val key: AttributeKey<ApiKeyPlugin>
            get() = AttributeKey(name = API_KEY_NAME)

        override fun prepare(block: Unit.() -> Unit): ApiKeyPlugin {
            return ApiKeyPlugin()
        }

        override fun install(plugin: ApiKeyPlugin, scope: HttpClient) {
            scope.requestPipeline.intercept(Before) {
                context.url.parameters.append(API_KEY_NAME, "56fc6c6cb76c0864b4cd055080568268")
            }
        }


    }
}

fun createApiKeyPlugin() = createClientPlugin(name = "ApiKeyPlugin") {
    on(SetupRequest) { builder ->
        builder.url.parameters.apply {
            append(API_KEY_NAME, "56fc6c6cb76c0864b4cd055080568268")
            append(UNITS_NAME, "metric")
        }
    }
}
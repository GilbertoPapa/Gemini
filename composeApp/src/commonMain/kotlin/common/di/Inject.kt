package common.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

private fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            featuresModules
        )
    }

fun initKoin() = initKoin {}


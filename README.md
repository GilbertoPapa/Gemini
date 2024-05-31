# Gemini

![Licença](https://img.shields.io/badge/licença-MIT-blue.svg)
![Versão](https://img.shields.io/badge/versão-1.0.0-brightgreen.svg)

## Sobre o Projeto

Este projeto utiliza Kotlin Multiplatform para compartilhar código entre diferentes plataformas (Android, iOS, Web, etc.).

## Instalação

Instruções sobre como configurar o ambiente de desenvolvimento.

### Pré-requisitos

- [Fleet](https://www.jetbrains.com/fleet/) ou [Android Studio](https://developer.android.com/studio)
- [Kotlin](https://kotlinlang.org/)
- [Gradle](https://gradle.org/)


### API key 

- [AIStudio](https://aistudio.google.com/app/apikey)

Coloque aqui sua chave :

`{
"gemini_key": "gemini_key"
}`

## Diagrama de Arquitetura em Camadas

<img width="897" alt="Captura de Tela 2024-05-31 às 09 52 10" src="https://github.com/GilbertoPapa/Gemini/assets/15881202/a5d5d9fa-53e5-468f-9874-4545bc26282b">

## Estrutura do Projeto

Descrição da estrutura de diretórios e módulos do projeto.

```plaintext
├── Common/
│   ├── data.config/
│   │   ├── ConfigClient
│   │   └── ConfigClientConstants
│   ├── di/
│   │   ├── FeaturesModules
│   │   └── Inject
├── Gemini/
│   ├── Data/
│   │   ├── datasource/
│   │   │   └── remote/
│   │   │       ├── GeminiRemoteDataSource
│   │   │       └── GeminiRemoteDataSourceImpl
│   │   ├── config/
│   │   │   ├── file/
│   │   │   │   ├── FileConfigProvider
│   │   │   │   └── FileConfigProviderImpl
│   │   │   ├── parser/
│   │   │   │   ├── JsonParser
│   │   │   │   └── JsonParserImpl
│   │   │   └── resource/
│   │   │       ├── ResourceReader
│   │   │       └── ResourceReaderImpl
│   │   ├── mapper/
│   │   │   └── GeminiMapper
│   │   ├── model/
│   │   │   ├── Config
│   │   │   ├── GeminiRequest
│   │   │   └── GeminiResponse
│   │   ├── repository/
│   │   │   ├── GeminiRepositoryImpl
│   │   │   └── KeyRepositoryImpl
│   │   ├── service/
│   │   │   └── GeminiService
│   │   └── di.provider/
│   │       └── GeminiProvider
│   ├── Domain/
│   │   ├── model/
│   │   │   └── GeminiDTO
│   │   ├── repository/
│   │   │   ├── KeyRepository
│   │   │   └── GeminiRepository
│   │   └── usecase/
│   │       ├── GeminiUseCase
│   │       └── KeyUseCase
│   ├── Presentation/
│   │   ├── ui.component/
│   │   │   ├── GenerateButton
│   │   │   ├── SeedInputField
│   │   │   └── StateContent
│   │   ├── screen/
│   │   │   └── GeminiScreen
│   │   └── viewmodel/
│   │       ├── GeminiState
│   │       └── GeminiViewModel
```

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.


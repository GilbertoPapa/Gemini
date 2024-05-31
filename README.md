# Nome do Projeto KMP

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


## Diagrama de Arquitetura em Camadas

![Captura de Tela 2024-05-31 às 09.52.10.png](..%2F..%2FDesktop%2FCaptura%20de%20Tela%202024-05-31%20%C3%A0s%2009.52.10.png)

## Estrutura do Projeto

Descrição da estrutura de diretórios e módulos do projeto.

```plaintext
├── Common/
│   ├── data.config/
│   │   ├── ConfigClient
│   │   └── ConfigClientConstants
│   ├── di/
│   │   ├── FeaturesModules.kt
│   │   └── Inject.kt
├── Gemini/
│   ├── Data/
│   │   ├── datasource/
│   │   │   ├── GeminiDataSource
│   │   │   └── GeminiDataSourceImpl
│   │   ├── keys/
│   │   │   └── ServiceConstants
│   │   ├── mapper/
│   │   │   └── GeminiMapper
│   │   ├── model/
│   │   │   ├── GeminiRequest.kt
│   │   │   └── GeminiResponse.kt
│   │   ├── repository/
│   │   │   └── GeminiRepositoryImpl
│   │   ├── service/
│   │   │   └── GeminiService
│   │   └── di.provider/
│   │       └── GeminiProvider
├── Domain/
│   ├── model/
│   │   └── GeminiDTO
├── Presentation/
│   ├── ui.component/
│   │   ├── GenerateButton.kt
│   │   ├── SeedInputField.kt
│   │   └── StateContent.kt
│   ├── screen/
│   │   └── GeminiScreen.kt
│   └── ViewModel/
│       ├── GeminiState
│       └── GeminiViewModel
```

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.


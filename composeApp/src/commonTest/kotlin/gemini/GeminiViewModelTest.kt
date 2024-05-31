package gemini

import gemini.domain.model.GeminiDTO
import gemini.domain.repository.GeminiRepository
import gemini.domain.usecase.GeminiUseCase
import gemini.presentation.viewmodel.GeminiState
import gemini.presentation.viewmodel.GeminiViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*
import kotlin.test.*

@ExperimentalCoroutinesApi
class GeminiViewModelTest {

    private lateinit var geminiRepository: FakeGeminiRepository
    private lateinit var geminiUseCase: GeminiUseCase
    private lateinit var viewModel: GeminiViewModel

    @BeforeTest
    fun setup() {
        geminiRepository = FakeGeminiRepository()
        geminiUseCase = GeminiUseCase(geminiRepository)
        viewModel = GeminiViewModel(geminiUseCase, Dispatchers.IO)
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Given a seed When postPrompt is called Then state should be ShowDescription`() = runTest {
        // Given
        val seed = "test_seed"
        val description = "test_description"
        geminiRepository.result = flow { emit(GeminiDTO(description)) }

        // When
        viewModel.postPrompt(seed)

        // Then
        assertEquals(GeminiState.Loading, viewModel.geminiState.value)
        advanceUntilIdle()
        assertEquals(GeminiState.ShowDescription(description), viewModel.geminiState.value)
    }

    @Test
    fun `Given a seed When postPrompt is called and an error occurs Then state should be ShowError`() = runTest {
        // Given
        val seed = "test_seed"
        val throwable = RuntimeException("Test exception")
        geminiRepository.result = flow { throw throwable }

        // When
        viewModel.postPrompt(seed)

        // Then
        assertEquals(GeminiState.ShowError, viewModel.geminiState.value)
    }
}

class FakeGeminiRepository : GeminiRepository {
    var result: Flow<GeminiDTO> = flowOf()

    override fun postPromptGemini(seed: String): Flow<GeminiDTO> {
        return result
    }
}


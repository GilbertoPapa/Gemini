package gemini.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import gemini.presentation.ui.component.GenerateButton
import gemini.presentation.ui.component.SeedInputField
import gemini.presentation.ui.component.StateContent
import org.koin.mp.KoinPlatform.getKoin
import gemini.presentation.viewmodel.GeminiViewModel

@Composable
fun GeminiScreen() {
    val geminiViewModel: GeminiViewModel = getKoin().get()
    val geminiState by geminiViewModel.geminiState.collectAsState()
    var seed by remember { mutableStateOf("") }

    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            item {
                SeedInputField(seed, onValueChange = { seed = it })
                GenerateButton(onClick = { geminiViewModel.postPrompt(seed) })
                StateContent(state = geminiState)
            }
        }
    }
}
package gemini.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gemini.presentation.viewmodel.GeminiState

@Composable
fun StateContent(
    state: GeminiState,
    modifier: Modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (state) {
            is GeminiState.ShowDescription -> {
                Text(text = state.description)
            }

            is GeminiState.ShowError -> {
                Text(text = "Erro ao gerar descrição")
            }

            is GeminiState.Loading -> {
                CircularProgressIndicator()
            }

            is GeminiState.Empty -> {
                Text(text = "Pergunte algo")
            }
        }
    }
}
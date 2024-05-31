package gemini.presentation.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GenerateButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text("Gerar")
    }
}
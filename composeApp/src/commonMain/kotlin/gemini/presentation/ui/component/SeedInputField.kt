package gemini.presentation.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SeedInputField(
    seed: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp).fillMaxWidth(0.8f)
) {
    OutlinedTextField(
        value = seed,
        onValueChange = onValueChange,
        label = { Text("Promt") },
        modifier = modifier
    )
}
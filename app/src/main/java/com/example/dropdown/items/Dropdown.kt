import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DropdownRow() {
    var expandedColor by remember { mutableStateOf(false) }
    var tempSelectedColor by remember { mutableStateOf("Negro") }
    var appliedColor by remember { mutableStateOf("Negro") }
    val colors = mapOf("Rojo" to Color.Red, "Azul" to Color.Blue, "Verde" to Color.Green, "Rosa" to Color.Magenta, "Negro" to Color.Black)

    var expandedTypography by remember { mutableStateOf(false) }
    var tempSelectedTypography by remember { mutableStateOf("Defecto") }
    var appliedTypography by remember { mutableStateOf("Defecto") }
    val typographies = mapOf("Sans Serif" to FontFamily.SansSerif, "Serif" to FontFamily.Serif, "Monospace" to FontFamily.Monospace, "Cursiva" to FontFamily.Cursive, "Defecto" to FontFamily.Default)

    fun Aplicador() {
        appliedColor = tempSelectedColor
        appliedTypography = tempSelectedTypography
    }

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Box {
                OutlinedButton(onClick = { expandedColor = true }) { Text(tempSelectedColor) }
                DropdownMenu(expanded = expandedColor, onDismissRequest = { expandedColor = false }) {
                    colors.keys.forEach { color ->
                        DropdownMenuItem(onClick = {
                            tempSelectedColor = color
                            expandedColor = false
                        }, text = { Text(color) })
                    }
                }
            }

            Box {
                OutlinedButton(onClick = { expandedTypography = true }) { Text(tempSelectedTypography) }
                DropdownMenu(expanded = expandedTypography, onDismissRequest = { expandedTypography = false }) {
                    typographies.keys.forEach { typography ->
                        DropdownMenuItem(onClick = {
                            tempSelectedTypography = typography
                            expandedTypography = false
                        }, text = { Text(typography) })
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Texto de prueba",
            fontSize = 24.sp,
            fontFamily = typographies[appliedTypography] ?: FontFamily.SansSerif,
            color = colors[appliedColor] ?: Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = { Aplicador() }, modifier = Modifier.fillMaxWidth()) {
            Text("Aplicar Cambios")
        }
    }
}

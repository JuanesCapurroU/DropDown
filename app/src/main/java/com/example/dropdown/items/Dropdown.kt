import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
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
    var clicked by remember { mutableStateOf(false) }

    val limeGreen = Color(0xFF32CD32)
    val White = Color(0xFFFFFFFF)

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = limeGreen
            ) {
                Text(
                    text = "Desarrollado por Juan Capurro",
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
            }
        },
        containerColor = Color(0xFFFAE6CB)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Elija un Color y una fuente para visualizarla, como se vería...",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(40.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                    Box {
                        OutlinedButton(
                            onClick = { expandedColor = true },
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = limeGreen
                            )
                        ) {
                            Text(tempSelectedColor)
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown icon"
                            )
                        }

                        DropdownMenu(
                            expanded = expandedColor,
                            onDismissRequest = { expandedColor = false }
                        ) {
                            colors.keys.forEach { color ->
                                DropdownMenuItem(
                                    onClick = {
                                        tempSelectedColor = color
                                        expandedColor = false
                                    },
                                    text = { Text(color) }
                                )
                            }
                        }
                    }

                    Box {
                        OutlinedButton(
                            onClick = { expandedTypography = true },
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = limeGreen
                            )
                        ) {
                            Text(tempSelectedTypography)
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Dropdown icon"
                            )
                        }

                        DropdownMenu(
                            expanded = expandedTypography,
                            onDismissRequest = { expandedTypography = false }
                        ) {
                            typographies.keys.forEach { typography ->
                                DropdownMenuItem(
                                    onClick = {
                                        tempSelectedTypography = typography
                                        expandedTypography = false
                                    },
                                    text = { Text(typography) }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "Texto de prueba",
                    fontSize = 40.sp,
                    fontFamily = typographies[appliedTypography] ?: FontFamily.SansSerif,
                    color = colors[appliedColor] ?: Color.Black
                )

                Spacer(modifier = Modifier.height(40.dp))

                OutlinedButton(
                    onClick = {
                        Aplicador()
                        clicked = true
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (clicked) limeGreen else Color.Transparent,
                        contentColor = if (clicked) White else Color.Black
                    )
                ) {
                    Text("Aplicar Cambios")
                }
            }
        }
    }
}
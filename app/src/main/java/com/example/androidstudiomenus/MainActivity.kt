package com.example.androidstudiomenus

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MenuScreen()
        }
    }
}

@Composable
fun MenuScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Menu1()
        Spacer(modifier = Modifier.height(16.dp))
        Menu2()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu1() {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    TopAppBar(
        title = { Text("CFGS de informatica") },
        actions = {
            IconButton(onClick = { expanded = true }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menú")
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Clase DAM") },
                    onClick = {  }
                )
                //Elemento del menu en el que si pulsamos se cierra la actividad
                DropdownMenuItem(
                    text = { Text("Clase DAW") },
                    onClick = { if (context is Activity) { context.finish()} }
                )
                DropdownMenuItem(
                    text = { Text("Clase ASIR") },
                    onClick = { /* Acción para Opción 3 */ }
                )
            }
        }
    )
}

@Composable
fun Menu2() {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("Selecciona una opción") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { expanded = true }) {
            Text(selectedItem)
            Icon(Icons.Filled.MoreVert, contentDescription = "Mostrar menú")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        )
        {
            DropdownMenuItem(
                text = { Text("Clase DAW") },
                onClick = {
                    selectedItem = "Clase DAW"
                    expanded = false
                }
            )

            DropdownMenuItem(
                text = { Text("Clase DAM") },
                onClick = {
                    selectedItem = "Clase DAM"
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Clase ASIR") },
                onClick = {
                    selectedItem = "Clase ASIR"
                    expanded = false
                }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {

}
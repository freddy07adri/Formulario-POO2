package com.example.formulario.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.tensorflow.lite.schema.Padding

@Composable
fun Formulario() {
    var nombre by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    var edad by remember { mutableStateOf(value = "") }

    val nombreError = nombre.isBlank()
    val emailError = email.isBlank() ||
            !android.util.Patterns.EMAIL_ADDRESS.matcher( email).matches()
    val edadError = edad.isBlank() || edad.toIntOrNull() == null

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(Padding.Values = padding)
                .padding(all = 16.dp)
        ) {
            Text("Formulario", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = nombre,
                onValueChange = {nombre = it},
                label = {Text("Nombre")},
                isError = nombreError,
                supportingText = {
                    Text("Nombre Requerido")
                }
            )
        }
    }



}
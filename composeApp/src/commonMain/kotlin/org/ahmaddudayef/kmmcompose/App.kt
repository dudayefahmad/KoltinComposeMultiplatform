package org.ahmaddudayef.kmmcompose

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    viewModel: AppViewModel = viewModel { AppViewModel() }
) {
    println("load app")

    MaterialTheme {

    }

}
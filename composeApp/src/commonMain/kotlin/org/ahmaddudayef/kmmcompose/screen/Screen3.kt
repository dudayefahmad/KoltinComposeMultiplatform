package org.ahmaddudayef.kmmcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ahmaddudayef.kmmcompose.navigation.LocalNavigator

@Composable
fun Screen3() {
    val navigator = LocalNavigator.current

    Column {
        Button(
            onClick = {
                navigator.back()
            }
        ) {
            Text("Back")
        }

        Spacer(Modifier.height(12.dp))

        Text("Text screen 3")

        Spacer(Modifier.height(12.dp))
    }
}
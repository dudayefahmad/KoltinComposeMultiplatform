package org.ahmaddudayef.kmmcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ahmaddudayef.kmmcompose.navigation.LocalNavigationComponent
import org.ahmaddudayef.kmmcompose.navigation.Router

@Composable
fun Screen2() {

    val navigationComponent = LocalNavigationComponent.current

    Column {
        Button(
            onClick = {
                navigationComponent.back()
            }
        ) {
            Text("Back")
        }

        Spacer(Modifier.height(12.dp))

        Text("Text screen 2")

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = {
                navigationComponent.navigate(Router.Screen3)
            }
        ) {
            Text("Navigate to screen 3")
        }
    }
}
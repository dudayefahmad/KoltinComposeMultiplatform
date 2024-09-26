package org.ahmaddudayef.kmmcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.bumble.appyx.navigation.integration.IosNodeHost
import com.bumble.appyx.navigation.integration.MainIntegrationPoint
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import org.ahmaddudayef.kmmcompose.navigation.RootNode

val backEvents: Channel<Unit> = Channel()
val integrationPoint = MainIntegrationPoint()

fun MainViewController() = ComposeUIViewController {
    IosNodeHost(
        onBackPressedEvents = backEvents.receiveAsFlow(),
        integrationPoint = integrationPoint,
        modifier = Modifier.fillMaxSize()
    ) {
        RootNode(it)
    }
}
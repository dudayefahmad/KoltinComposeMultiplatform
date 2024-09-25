package org.ahmaddudayef.kmmcompose

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.ahmaddudayef.kmmcompose.entity.data.User
import org.ahmaddudayef.kmmcompose.navigation.LocalNavigationComponent
import org.ahmaddudayef.kmmcompose.navigation.NavigationComponent
import org.ahmaddudayef.kmmcompose.navigation.Router
import org.ahmaddudayef.kmmcompose.screen.Screen1
import org.ahmaddudayef.kmmcompose.screen.Screen2
import org.ahmaddudayef.kmmcompose.screen.Screen3
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    viewModel: AppViewModel = viewModel { AppViewModel() }
) {
//    val stateModel by viewModel.stateModelData.collectAsState()
    val navigationComponent = remember { NavigationComponent() }
    val router by navigationComponent.stateRouter.collectAsState()

    MaterialTheme {

        CompositionLocalProvider(
            LocalNavigationComponent provides navigationComponent
        ) {
            AnimatedContent(
                targetState = router
            ) {
                when (it) {
                    is Router.Screen1 -> {
                        Screen1()
                    }
                    is Router.Screen2 -> {
                        Screen2()
                    }
                    is Router.Screen3 -> {
                        Screen3()
                    }
                }
            }
        }

//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Button(onClick = {
//                viewModel.handleIntent(AppIntent.GetApi)
//            }) {
//                Text("Test Api")
//            }
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            with(stateModel.reqresResponse) {
//                onIdle {}
//                onLoading {
//                    LoadingContent()
//                }
//                onSuccess { user ->
//                    SuccessContent(user)
//                }
//                onFailure { throwable ->
//                    FailureContent(throwable)
//                }
//            }
//
//            Spacer(Modifier.height(24.dp))
//            Text(
//                text = stateModel.counter.toString()
//            )
//            Spacer(Modifier.height(12.dp))
//            Button(
//                onClick = {
//                    viewModel.handleIntent(
//                        AppIntent.UpdateCounter
//                    )
//                }
//            ) {
//                Text("Update Counter")
//            }
//
//            Spacer(Modifier.height(12.dp))
//            Button(
//                onClick = {
//                    viewModel.restartState()
//                }
//            ) {
//                Text("Restart Model")
//            }
//        }
    }
}

@Composable
fun LoadingContent() {
    CircularProgressIndicator()
}

@Composable
fun SuccessContent(user: User) {
    Column {
        Text(
            text = user.name
        )
    }
}

@Composable
fun FailureContent(throwable: Throwable) {
    Text(
        text = throwable.message.orEmpty(), color = Color.Red
    )
}
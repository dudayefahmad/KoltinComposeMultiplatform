package org.ahmaddudayef.kmmcompose.navigation

import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.operation.pop
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.components.backstack.ui.fader.BackStackFader
import com.bumble.appyx.components.backstack.ui.parallax.BackStackParallax
import com.bumble.appyx.interactions.gesture.GestureFactory
import com.bumble.appyx.navigation.composable.AppyxNavigationContainer
import com.bumble.appyx.navigation.modality.NodeContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.navigation.node.node
import org.ahmaddudayef.kmmcompose.isAndroid
import org.ahmaddudayef.kmmcompose.screen.Screen1
import org.ahmaddudayef.kmmcompose.screen.Screen2
import org.ahmaddudayef.kmmcompose.screen.Screen3

class RootNode(
    nodeContext: NodeContext,
    private val backStack: BackStack<NavTarget> = BackStack(
        model = BackStackModel(
            initialTarget = NavTarget.Screen1,
            savedStateMap = nodeContext.savedStateMap
        ),
        visualisation = {
            if (isAndroid) {
                BackStackFader(it, defaultAnimationSpec = spring())
            } else {
                BackStackFader(it)
            }
        },
        gestureFactory = {
            if (isAndroid) {
                GestureFactory.Noop()
            } else {
                BackStackParallax.Gestures(it)
            }
        }
    )
) : Node<NavTarget>(
    nodeContext = nodeContext,
    appyxComponent = backStack
) {

    @Composable
    override fun Content(modifier: Modifier) {
        val navigator = remember {
            object : Navigator {
                override fun navigate(navTarget: NavTarget) {
                    backStack.push(navTarget)
                }

                override fun back() {
                    backStack.pop()
                }
            }
        }

        CompositionLocalProvider(
            LocalNavigator provides navigator
        ) {
            AppyxNavigationContainer(
                appyxComponent = backStack
            )
        }
    }

    override fun buildChildNode(navTarget: NavTarget, nodeContext: NodeContext): Node<*> {
        return when (navTarget) {
            is NavTarget.Screen1 -> node(nodeContext) {
                BoxBackground {
                    Screen1()
                }
            }
            is NavTarget.Screen2 -> node(nodeContext) {
                BoxBackground {
                    Screen2(navTarget.name)
                }
            }
            is NavTarget.Screen3  -> node(nodeContext) {
                BoxBackground {
                    Screen3()
                }
            }
        }
    }

    @Composable
    private fun BoxBackground(
        content: @Composable () -> Unit
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = Color.White)
        ) {
            content.invoke()
        }
    }
}
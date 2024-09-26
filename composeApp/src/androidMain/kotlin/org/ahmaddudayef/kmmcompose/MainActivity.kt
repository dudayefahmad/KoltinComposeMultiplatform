package org.ahmaddudayef.kmmcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import com.bumble.appyx.navigation.integration.NodeActivity
import com.bumble.appyx.navigation.integration.NodeHost
import com.bumble.appyx.navigation.platform.AndroidLifecycle
import org.ahmaddudayef.kmmcompose.navigation.RootNode

class MainActivity : NodeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val lifecycleOwner = LocalLifecycleOwner.current
            NodeHost(
                lifecycle = AndroidLifecycle(lifecycleOwner.lifecycle),
                integrationPoint = appyxIntegrationPoint
            ) {
                RootNode(it)
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
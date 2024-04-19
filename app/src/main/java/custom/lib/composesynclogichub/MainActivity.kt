package custom.lib.composesynclogichub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import custom.lib.composesync_logic_hub.AppButton
import custom.lib.composesync_logic_hub.AppText
import custom.lib.composesync_logic_hub.ComposeSyncLogicHub
import custom.lib.composesynclogichub.ui.theme.ComposeSyncLogicHubTheme
import custom.lib.droid.droid_craft.DroidForgeMain
import custom.lib.droid.droid_craft.ShortAppInfo

class MainActivity : ComponentActivity() {



    // val a = DroidForgeMain(this, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val main = ComposeSyncLogicHub(
            application = application,
            activity = this
        )




        setContent {
            ComposeSyncLogicHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    main.AppContentText(
                        url = "https://github.com",
                        devKey = "u7pZpr4bJ7kxaAujH5ok3Z",
                        appShortInfo = ShortAppInfo(
                            name = stringResource(id = R.string.app_name),
                            ic = R.drawable.ic_launcher_background
                        )
                    ) {
                        Text(text = "Hello World From Text Module")
                    }

                }
            }
        }
    }
}

package custom.lib.composesync_logic_hub

import android.app.Application
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import custom.lib.button_application.ButtonBrushBackground
import custom.lib.button_application.PosIcon
import custom.lib.button_application.invertColor
import custom.lib.droid.droid_craft.DroidForgeMain
import custom.lib.droid.droid_craft.ShortAppInfo

class ComposeSyncLogicHub(
    activity: ComponentActivity,
    application: Application,
) {
    private val main = DroidForgeMain(activity, application)


    private fun execute(
        url: String,
        devKey: String,
        appShortInfo: ShortAppInfo? = null,
        currentData: String = ""
    ): DroidForgeMain {

        main.apply {
            this.url = url
            this.appsCode = devKey
            this.applicationShortInformation = appShortInfo
            this.currentData = currentData

            this.start()
        }

        return  main

    }

    @Deprecated("Данная реализация вызывает сомнения! Она не гарантирует правильность работы.")
    @Composable
    fun AppContent(content: @Composable () -> Unit) {
        main.ShowContent {
            content()
        }
    }

    @Composable
    fun AppContentText(
        url: String,
        devKey: String,
        appShortInfo: ShortAppInfo? = null,
        currentData: String = "",
        content: @Composable () -> Unit
    ) {
        execute(
            url = url,
            devKey = devKey,
            appShortInfo = appShortInfo,
            currentData = currentData,
        ).ShowContent {
            content()
        }
    }
}



object AppButton {
    @Composable
    fun ButtonPrimary(
        value: String,
        background: Color,
        modifier: Modifier,
        onClick: () -> Unit
    ) {
        custom.lib.button_application.ButtonPrimary(
            value = value,
            background = background,
            contentColor = background.invertColor(),
            modifier = modifier
        ) {
            onClick()
        }
    }

    @Composable
    fun ButtonSecondaryIcon(
        value: String,
        icon: ImageVector,
        posIcon: PosIcon = PosIcon.START,
        isActive: Boolean = false,
        onClick: () -> Unit,
    ) {
        custom.lib.button_application.ButtonSecondaryIcon(
            value = value,
            icon = icon,
            posIcon = posIcon,
            isActive = isActive,
        ) { onClick() }
    }

    @Composable
    fun ButtonSecondary(
        value: String,
        isActive: Boolean = false,
        onClick: () -> Unit,
    ) {
        custom.lib.button_application.ButtonSecondary(
            value = value,
            isActive = isActive
        ) { onClick() }
    }

    @Composable
    fun ButtonSecondaryCircle(
        value: String,
        isActive: Boolean = false,
        back: ButtonBrushBackground? = null,
        onClick: () -> Unit,
    ) {
        custom.lib.button_application.ButtonSecondaryCircle(
            value = value,
            isActive = isActive,
            back = back,
        ) { onClick() }
    }
}


object AppText {

    @Composable
    fun PrimaryText(
        value: String,
        color: Color,
        modifier: Modifier = Modifier,
        textAlign: TextAlign = TextAlign.Start,
        fontWeight: FontWeight = FontWeight.Normal,
        maxLines: Int = Int.MAX_VALUE,
    ) {
        custom.lib.text_application.PrimaryText(
            value = value,
            color = color,
            modifier = modifier,
            textAlign = textAlign,
            fontWeight = fontWeight,
            maxLines = maxLines
        )
    }

    @Composable
    fun SecondaryText(
        value: String,
        color: Color,
        modifier: Modifier = Modifier,
        textAlign: TextAlign = TextAlign.Start,
        fontWeight: FontWeight = FontWeight.Normal,
        maxLines: Int = Int.MAX_VALUE,
    ) {
        custom.lib.text_application.SecondaryText(
            value = value,
            color = color,
            modifier = modifier,
            textAlign = textAlign,
            fontWeight = fontWeight,
            maxLines = maxLines
        )
    }

    @Composable
    fun SmallText(
        value: String,
        color: Color,
        modifier: Modifier = Modifier,
        textAlign: TextAlign = TextAlign.Start,
        fontWeight: FontWeight = FontWeight.Normal,
        maxLines: Int = Int.MAX_VALUE,
    ) {
        custom.lib.text_application.SmallText(
            value = value,
            color = color,
            modifier = modifier,
            textAlign = textAlign,
            fontWeight = fontWeight,
            maxLines = maxLines
        )
    }

}
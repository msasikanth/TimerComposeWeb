package dev.sasikanth.web

import androidx.compose.runtime.Composable
import kotlinx.datetime.Instant
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun TimerText(time: Instant) {
    Div(attrs = {
        classes(
            AppStyleSheet.text,
            AppStyleSheet.disableTextSelect
        )
    }) {
        Text(formatTime(time))
    }
}

private fun formatTime(time: Instant) = time
    .toString()
    .split("T")
    .get(index = 1)
    .replace("Z", "")
    .split(":")
    .drop(1)
    .joinToString(":")

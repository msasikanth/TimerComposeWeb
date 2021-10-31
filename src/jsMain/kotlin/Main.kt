import androidx.compose.runtime.*
import dev.sasikanth.web.AppStyleSheet
import dev.sasikanth.web.TimerText
import kotlinx.coroutines.delay
import kotlinx.datetime.Instant
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() {
    val interval = Duration.seconds(1)

    renderComposable(rootElementId = "root") {
        Style(AppStyleSheet)

        var timer by remember { mutableStateOf(Duration.minutes(10)) }

        LaunchedEffect(timer) {
            if (timer != Duration.ZERO) {
                delay(interval)
                timer = timer.minus(interval)
            }
        }

        Div(attrs = {
            classes(AppStyleSheet.background)
        }) {
            val time = Instant.fromEpochMilliseconds(timer.inWholeMilliseconds)
            TimerText(time)
        }
    }
}

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    var timer by mutableStateOf(Duration.minutes(10))

    renderComposable(rootElementId = "root") {
        val time = Instant.fromEpochMilliseconds(timer.inWholeMilliseconds)

        Style(AppStyleSheet)

        LaunchedEffect(timer) {
            if (timer != Duration.ZERO) {
                delay(interval)
                timer = timer.minus(interval)
            }
        }

        Div(attrs = {
            classes(AppStyleSheet.background)
        }) {
            TimerText(time)
        }
    }
}

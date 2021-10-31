import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.datetime.Instant
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.HTMLDivElement
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() {
    val interval = Duration.seconds(1)

    renderComposable(rootElementId = "root") {
        var timer by remember { mutableStateOf(Duration.minutes(10)) }

        LaunchedEffect(timer) {
            if (timer != Duration.ZERO) {
                delay(interval)
                timer = timer.minus(interval)
            }
        }

        val backgroundAttrs: AttrsBuilder<HTMLDivElement>.() -> Unit = {
            style {
                borderRadius(16.px)
                backgroundColor(Color.red)
                padding(16.px)
                display(DisplayStyle.InlineBlock)
            }
        }
        val textAttrs: AttrsBuilder<HTMLDivElement>.() -> Unit = {
            style {
                color(Color.white)
                fontSize(128.px)
                fontFamily("Manrope", "sans-serif")
            }
        }

        Div(backgroundAttrs) {
            Div(textAttrs) {
                val time = Instant.fromEpochMilliseconds(timer.inWholeMilliseconds)
                val formattedString = time
                    .toString()
                    .split("T")
                    .get(index = 1)
                    .replace("Z", "")
                    .split(":")
                    .drop(1)
                    .joinToString(":")

                Text(formattedString)
            }
        }
    }
}

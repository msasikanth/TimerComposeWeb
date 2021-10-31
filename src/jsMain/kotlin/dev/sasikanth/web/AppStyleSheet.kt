package dev.sasikanth.web

import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.selectors.hover
import org.jetbrains.compose.web.css.selectors.plus

object AppStyleSheet : StyleSheet() {

    val background by style {
        borderRadius(16.px)
        backgroundColor(Color.red)
        padding(16.px)
        display(DisplayStyle.InlineBlock)

        self + hover() style {
            backgroundColor(Color.white)
        }
    }

    val text by style {
        color(Color.white)
        fontSize(128.px)
        fontFamily("Manrope", "sans-serif")

        self + hover() style {
            color(Color.red)
        }
    }
}

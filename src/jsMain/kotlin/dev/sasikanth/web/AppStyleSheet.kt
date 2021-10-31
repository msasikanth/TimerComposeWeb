package dev.sasikanth.web

import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.selectors.hover
import org.jetbrains.compose.web.css.selectors.plus

object AppStyleSheet : StyleSheet() {

    val background by style {
        position(Position.Absolute)
        top(50.percent)
        left(50.percent)
        property("transform", "translate(-50%, -50%")
    }

    val text by style {
        borderRadius(16.px)
        backgroundColor(Color.red)
        padding(16.px)
        display(DisplayStyle.InlineBlock)
        color(Color.white)
        fontSize(128.px)
        fontFamily("Manrope", "sans-serif")

        self + hover() style {
            color(Color.red)
            backgroundColor(Color.white)
        }
    }

    val disableTextSelect by style {
        property("-webkit-user-select", "none")
        property("-moz-user-select", "none")
        property("-ms-user-select", "none")
        property("user-select", "none")
    }
}

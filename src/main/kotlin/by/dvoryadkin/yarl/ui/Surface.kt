package by.dvoryadkin.yarl.ui

import com.googlecode.lanterna.graphics.TextGraphics

abstract class Surface(
    protected val graphics: TextGraphics) {
    abstract fun update()
}

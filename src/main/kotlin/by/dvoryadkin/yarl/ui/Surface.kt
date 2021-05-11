package by.dvoryadkin.yarl.ui

import by.dvoryadkin.yarl.engine.GameContext
import com.googlecode.lanterna.graphics.TextGraphics

abstract class Surface(
    protected val graphics: TextGraphics,
    protected val context: GameContext
) {
    abstract fun update()
}

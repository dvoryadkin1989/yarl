package by.dvoryadkin.yarl.ui

import by.dvoryadkin.yarl.engine.GameContext
import com.googlecode.lanterna.TerminalPosition.TOP_LEFT_CORNER
import com.googlecode.lanterna.graphics.TextGraphics

class GameSurface(graphics: TextGraphics, context: GameContext) : Surface(graphics, context) {
    override fun update() {
        graphics.fillRectangle(TOP_LEFT_CORNER, graphics.size, '.')
        graphics.drawRectangle(TOP_LEFT_CORNER, graphics.size, '#')
    }
}
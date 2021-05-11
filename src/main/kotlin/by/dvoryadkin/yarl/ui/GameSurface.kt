package by.dvoryadkin.yarl.ui

import com.googlecode.lanterna.TerminalPosition.TOP_LEFT_CORNER
import com.googlecode.lanterna.graphics.TextGraphics

class GameSurface(graphics: TextGraphics) : Surface(graphics) {
    override fun update() {
        graphics.fillRectangle(TOP_LEFT_CORNER, graphics.size, '.')
        graphics.drawRectangle(TOP_LEFT_CORNER, graphics.size, '#')
    }
}
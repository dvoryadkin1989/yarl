package by.dvoryadkin.yarl.ui

import com.googlecode.lanterna.TerminalPosition.TOP_LEFT_CORNER
import com.googlecode.lanterna.graphics.TextGraphics

class PlayerStatsSurface(graphics: TextGraphics) : Surface(graphics) {
    override fun update() {
        graphics.putString(TOP_LEFT_CORNER.withRelative(1, 1), "HP: 129")
    }
}
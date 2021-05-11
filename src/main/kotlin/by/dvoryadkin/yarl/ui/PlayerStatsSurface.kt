package by.dvoryadkin.yarl.ui

import by.dvoryadkin.yarl.global.player
import com.googlecode.lanterna.TerminalPosition.TOP_LEFT_CORNER
import com.googlecode.lanterna.graphics.TextGraphics

class PlayerStatsSurface(graphics: TextGraphics) : Surface(graphics) {
    override fun update() {
        graphics.fillRectangle(TOP_LEFT_CORNER.withRelative(1, 1), graphics.size, ' ')
        graphics.putString(TOP_LEFT_CORNER.withRelative(1, 1), "HP: ${player.hp}")
    }
}
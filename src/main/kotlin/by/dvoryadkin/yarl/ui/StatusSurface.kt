package by.dvoryadkin.yarl.ui

import by.dvoryadkin.yarl.engine.GameContext
import com.googlecode.lanterna.TerminalPosition.TOP_LEFT_CORNER
import com.googlecode.lanterna.graphics.TextGraphics

class StatusSurface(graphics: TextGraphics, context: GameContext) : Surface(graphics, context) {
    override fun update() {
        graphics.fillRectangle(TOP_LEFT_CORNER.withRelative(1, 1), graphics.size, ' ')
        graphics.putString(TOP_LEFT_CORNER.withRelative(1, 1), "HP: ${context.player.hp}")
        graphics.putString(TOP_LEFT_CORNER.withRelative(1, 2), "Ticks: ${context.clock.getCurrentTicks()}")
    }
}
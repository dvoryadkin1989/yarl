package by.dvoryadkin.yarl.ui

import by.dvoryadkin.yarl.engine.GameContext
import com.googlecode.lanterna.TerminalPosition.TOP_LEFT_CORNER
import com.googlecode.lanterna.screen.Screen

class MainSurface(private val screen: Screen, context: GameContext) :
    Surface(screen.newTextGraphics(), context) {

    companion object {
        private const val STATUS_SURFACE_HEIGHT = 10
        private const val GAME_SURFACE_HEIGHT = 20
    }

    private val statusSurface = StatusSurface(
        graphics.newTextGraphics(
            TOP_LEFT_CORNER,
            graphics.size.withRows(STATUS_SURFACE_HEIGHT)
        ),
        context
    )

    private val gameSurface = GameSurface(
        graphics.newTextGraphics(
            TOP_LEFT_CORNER.withRelativeRow(STATUS_SURFACE_HEIGHT),
            graphics.size.withRows(GAME_SURFACE_HEIGHT)
        ),
        context
    )

    override fun update() {
        statusSurface.update()
        gameSurface.update()
        screen.refresh()
    }
}
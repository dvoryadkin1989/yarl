package by.dvoryadkin.yarl.ui

import com.googlecode.lanterna.TerminalPosition.TOP_LEFT_CORNER
import com.googlecode.lanterna.screen.Screen

class MainSurface(private val screen: Screen) : Surface(screen.newTextGraphics()) {

    companion object {
        private const val PLAYER_STATS_SURFACE_HEIGHT = 10
        private const val GAME_SURFACE_HEIGHT = 20
    }

    private val playerStatsSurface = PlayerStatsSurface(
        graphics.newTextGraphics(
            TOP_LEFT_CORNER,
            graphics.size.withRows(PLAYER_STATS_SURFACE_HEIGHT)
        )
    )

    private val gameSurface = GameSurface(
        graphics.newTextGraphics(
            TOP_LEFT_CORNER.withRelativeRow(PLAYER_STATS_SURFACE_HEIGHT),
            graphics.size.withRows(GAME_SURFACE_HEIGHT)
        )
    )

    override fun update() {
        playerStatsSurface.update()
        gameSurface.update()
        screen.refresh()
    }
}
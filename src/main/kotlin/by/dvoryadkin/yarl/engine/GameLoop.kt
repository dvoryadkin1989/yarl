package by.dvoryadkin.yarl.engine

import by.dvoryadkin.yarl.global.player
import by.dvoryadkin.yarl.ui.MainSurface
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.terminal.Terminal

class GameLoop(private val terminal: Terminal, private val mainSurface: MainSurface) {
    private val eventConsumer: EventConsumer = EventQueue()
    fun start() {
        do {
            mainSurface.update()
            val event = eventConsumer.poll()
            val keyStroke = terminal.readInput()
            if (keyStroke == KeyStroke.fromString("a")) {
                player.hp -= 1
            }
        } while (keyStroke.keyType != KeyType.Escape)
    }
}
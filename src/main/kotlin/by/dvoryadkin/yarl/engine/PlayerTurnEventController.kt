package by.dvoryadkin.yarl.engine

import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.terminal.Terminal
import org.springframework.stereotype.Service

@Service
class PlayerTurnEventController(
    private val eventPublisher: EventPublisher,
    private val terminal: Terminal,
    private val context: GameContext
) : EventController {

    override fun handleEvent(event: Event) {
        val keyStroke = terminal.readInput()
        if (keyStroke == KeyStroke.fromString("a")) {
            context.player.hp -= 1
            eventPublisher.publishEvent(PlayerTurnEvent(), 1000)
        }
    }

    override fun supportsEvent(event: Event): Boolean = event is PlayerTurnEvent
}
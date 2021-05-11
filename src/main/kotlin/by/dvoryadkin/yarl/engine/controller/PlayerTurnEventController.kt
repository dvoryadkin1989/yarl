package by.dvoryadkin.yarl.engine.controller

import by.dvoryadkin.yarl.engine.*
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.terminal.Terminal
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service

@Order(1)
@Service
class PlayerTurnEventController(
    private val eventPublisher: EventPublisher,
    private val terminal: Terminal,
    private val context: GameContext
) : EventController {

    override fun handleEvent(event: Event) {
        val player = context.player
        if (player.hp <= 0) {
            player.isDead = true
            eventPublisher.publishEvent(GameOverEvent(), 0)
        } else {
            val keyStroke = terminal.readInput()
            if (keyStroke == KeyStroke.fromString("a")) {
                player.hp -= 10
                eventPublisher.publishEvent(PlayerTurnEvent(), 1000)
            }
        }
    }

    override fun supportsEvent(event: Event): Boolean = event is PlayerTurnEvent
}
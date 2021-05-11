package by.dvoryadkin.yarl.engine.controller

import by.dvoryadkin.yarl.engine.Event
import by.dvoryadkin.yarl.engine.GameOverEvent
import com.googlecode.lanterna.terminal.Terminal
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service

@Service
@Order(0)
class GameOverEventController(private val terminal: Terminal) : EventController {
    override fun handleEvent(event: Event) {
        terminal.readInput()
    }

    override fun supportsEvent(event: Event) = event is GameOverEvent
}
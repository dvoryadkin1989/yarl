package by.dvoryadkin.yarl.engine

import by.dvoryadkin.yarl.ui.MainSurface
import org.springframework.stereotype.Service

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Service
class GameLoop(
    private val mainSurface: MainSurface,
    private val eventConsumer: EventConsumer,
    private val controllers: List<EventController>
) {
    private var gameFinished = false

    fun start() {
        while (!gameFinished) {
            mainSurface.update()
            val event = eventConsumer.poll()
            if (event != null) {
                controllers.filter { it.supportsEvent(event) }.forEach {
                    it.handleEvent(event)
                }
            } else {
                gameFinished = true
            }
        }
    }
}
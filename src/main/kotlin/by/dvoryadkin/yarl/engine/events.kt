package by.dvoryadkin.yarl.engine

interface EventPublisher {
    fun publishEvent(event: Event, ticksOffset: Long)
}

interface EventConsumer {
    fun poll(): Event?
}

open class Event
class GameOverEvent : Event()
class PlayerTurnEvent : Event()
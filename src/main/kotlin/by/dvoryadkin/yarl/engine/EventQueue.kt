package by.dvoryadkin.yarl.engine

import org.springframework.stereotype.Service
import java.util.*

@Service
class EventQueue : EventPublisher, EventConsumer, Clock {
    private val eventQueue: Queue<EventHolder> = PriorityQueue()
    private var currentTicks: Long = 0L

    init {
        eventQueue.add(EventHolder(PlayerTurnEvent(), 0))
    }

    override fun publishEvent(event: Event, ticksOffset: Long) {
        assert(ticksOffset >= 0) { "ticksOffset must not be negative" }
        eventQueue.add(EventHolder(event, currentTicks + ticksOffset))
    }

    override fun poll(): Event? {
        val eventHolder = eventQueue.poll()
        currentTicks = eventHolder?.targetTicks ?: 0
        return eventHolder?.event
    }

    private data class EventHolder(val event: Event, val targetTicks: Long) : Comparable<EventHolder> {
        override fun compareTo(other: EventHolder) = this.targetTicks.compareTo(other.targetTicks)
    }

    override fun getCurrentTicks() = currentTicks
}
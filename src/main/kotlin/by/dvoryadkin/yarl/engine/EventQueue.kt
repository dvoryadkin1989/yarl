package by.dvoryadkin.yarl.engine

import java.util.*

interface EventPublisher {
    fun fireEvent(event: Event, ticksOffset: Long)
}

interface EventConsumer {
    fun poll(): Event?
}

class EventQueue : EventPublisher, EventConsumer {
    private val eventQueue: Queue<EventHolder> = PriorityQueue()
    private var currentTicks: Long = 0L

    override fun fireEvent(event: Event, ticksOffset: Long) {
        assert(ticksOffset > 0) { "ticksOffset must be positive" }
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
}
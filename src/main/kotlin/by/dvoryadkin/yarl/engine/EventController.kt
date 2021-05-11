package by.dvoryadkin.yarl.engine

interface EventController {
    fun handleEvent(event: Event)
    fun supportsEvent(event: Event): Boolean
}
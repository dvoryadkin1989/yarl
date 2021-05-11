package by.dvoryadkin.yarl.engine.controller

import by.dvoryadkin.yarl.engine.Event

interface EventController {
    fun handleEvent(event: Event)
    fun supportsEvent(event: Event): Boolean
}
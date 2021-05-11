package by.dvoryadkin.yarl.engine

import by.dvoryadkin.yarl.creatures.Player
import org.springframework.stereotype.Service

@Service
class GameContext(val clock: Clock) {
    val player = Player()
}
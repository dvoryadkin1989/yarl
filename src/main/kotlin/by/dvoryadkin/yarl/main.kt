package by.dvoryadkin.yarl

import by.dvoryadkin.yarl.engine.GameLoop
import by.dvoryadkin.yarl.ui.MainSurface
import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.awt.Frame

const val WINDOW_HEIGHT = 30
const val WINDOW_WIDTH = 40

@SpringBootApplication
class YarlApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        val terminal = createTerminal()
        val screen = TerminalScreen(terminal).apply {
            cursorPosition = null
            startScreen()
        }
        val mainSurface = MainSurface(screen)
        val gameLoop = GameLoop(terminal, mainSurface)
        gameLoop.start()
        terminal.bell()
    }

    private fun createTerminal(): Terminal {
        val defaultTerminalFactory = DefaultTerminalFactory()
        defaultTerminalFactory.setInitialTerminalSize(TerminalSize(WINDOW_WIDTH, WINDOW_HEIGHT))
        val terminal = defaultTerminalFactory.createTerminal()
        terminal.setCursorVisible(false)
        if (terminal is Frame) {
            terminal.isResizable = false
        }
        return terminal
    }
}

fun main(args: Array<String>) {
    runApplication<YarlApplication>(*args)
}


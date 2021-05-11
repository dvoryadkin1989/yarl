package by.dvoryadkin.yarl.bootconfig

import by.dvoryadkin.yarl.ui.MainSurface
import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.awt.Frame

@Configuration
class EngineConfig {
    companion object {
        const val WINDOW_HEIGHT = 30
        const val WINDOW_WIDTH = 40
    }
    @Bean
    fun terminal(): Terminal {
        val defaultTerminalFactory = DefaultTerminalFactory()
        defaultTerminalFactory.setInitialTerminalSize(TerminalSize(WINDOW_WIDTH, WINDOW_HEIGHT))
        val terminal = defaultTerminalFactory.createTerminalEmulator()
        terminal.setCursorVisible(false)
        if (terminal is Frame) {
            terminal.isResizable = false
        }
        return terminal
    }

    @Bean
    fun screen(): Screen = TerminalScreen(terminal()).apply {
        cursorPosition = null
        startScreen()
    }

    @Bean
    fun mainSurface(): MainSurface = MainSurface(screen())
}
package by.dvoryadkin.yarl

import by.dvoryadkin.yarl.engine.GameLoop
import com.googlecode.lanterna.terminal.Terminal
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import kotlin.system.exitProcess


@SpringBootApplication
class YarlApplication(private val terminal: Terminal, private val gameLoop: GameLoop) : CommandLineRunner {
    override fun run(vararg args: String?) {
        gameLoop.start()
        terminal.bell()
        terminal.close()
        exitProcess(0)
    }
}

fun main(args: Array<String>) {
    val builder = SpringApplicationBuilder(YarlApplication::class.java)
    builder.headless(false).run(*args)
}

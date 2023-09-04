package esperer.webfluxserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebfluxServerApplication

fun main(args: Array<String>) {
    runApplication<WebfluxServerApplication>(*args)
}

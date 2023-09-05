package esperer.webfluxserver.domain.auth.router

import esperer.webfluxserver.domain.auth.handler.AuthHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class AuthRouter {

    @Bean
    fun authBaseRouter(authHandler: AuthHandler) = coRouter {
        "users".nest {
            contentType(MediaType.APPLICATION_JSON)
            POST("/signup", authHandler::signUp)
            POST("/signin", authHandler::signIn)
            GET("/userinfo", authHandler::getUserInfo)
        }
    }
}
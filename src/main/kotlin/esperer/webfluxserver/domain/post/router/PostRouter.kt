package esperer.webfluxserver.domain.post.router

import esperer.webfluxserver.domain.post.handler.PostHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class PostRouter {

    @Bean
    fun postBaseRouter(postHandler: PostHandler) = coRouter {
        "/post".nest {
            contentType(MediaType.APPLICATION_JSON)
            POST("/", postHandler::createPost)
        }
    }
}
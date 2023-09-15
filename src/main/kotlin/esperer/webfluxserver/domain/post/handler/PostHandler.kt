package esperer.webfluxserver.domain.post.handler

import esperer.webfluxserver.domain.post.api.PostApi
import esperer.webfluxserver.domain.post.dto.CreatePostRequest
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import java.net.URI

@Component
class PostHandler(
    private val postApi: PostApi
) {

    suspend fun createPost(request: ServerRequest): ServerResponse {
        val requestBody = request.bodyToMono(CreatePostRequest::class.java).awaitSingle()
        postApi.createPost(requestBody)
        return ServerResponse.created(URI("/post")).buildAndAwait()
    }
}
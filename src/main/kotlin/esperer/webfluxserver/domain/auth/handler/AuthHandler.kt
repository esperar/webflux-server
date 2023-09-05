package esperer.webfluxserver.domain.auth.handler

import esperer.webfluxserver.domain.auth.api.AuthApi
import esperer.webfluxserver.domain.auth.dto.SignUpRequest
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import java.net.URI

@Component
class AuthHandler(
    private val authApi: AuthApi
) {

    suspend fun signUp(serverRequest: ServerRequest): ServerResponse {
        val requestBody = serverRequest.getUserSignInRequestBody()
        val tokenResponse = authApi.signUp(requestBody)
        return ServerResponse.created(URI("/users")).bodyValueAndAwait(tokenResponse)
    }

    private suspend fun ServerRequest.getUserSignInRequestBody() =
        this.bodyToMono(SignUpRequest::class.java).awaitSingle()
}
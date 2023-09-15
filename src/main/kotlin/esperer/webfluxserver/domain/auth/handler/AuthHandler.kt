package esperer.webfluxserver.domain.auth.handler

import esperer.webfluxserver.domain.auth.api.AuthApi
import esperer.webfluxserver.domain.auth.api.AuthApiImpl
import esperer.webfluxserver.domain.auth.dto.SignInRequest
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
        val requestBody = serverRequest.getUserSignUpRequestBody()
        val tokenResponse = authApi.signUp(requestBody)
        return ServerResponse.created(URI("/auth")).bodyValueAndAwait(tokenResponse)
    }

    private suspend fun ServerRequest.getUserSignUpRequestBody() =
        this.bodyToMono(SignUpRequest::class.java).awaitSingle()

    suspend fun signIn(serverRequest: ServerRequest): ServerResponse {
        val requestBody = serverRequest.getUserSignInRequestBody()
        val tokenResponse = authApi.signIn(requestBody)
        return ServerResponse.ok().bodyValueAndAwait(tokenResponse)
    }

    private suspend fun ServerRequest.getUserSignInRequestBody() =
        this.bodyToMono(SignInRequest::class.java).awaitSingle()

    suspend fun getUserInfo(serverRequest: ServerRequest): ServerResponse {
        val userInfoResponse = authApi.getUserInfo()
        return ServerResponse.ok().bodyValueAndAwait(userInfoResponse)
    }
}
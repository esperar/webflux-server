package esperer.webfluxserver.domain.auth.api

import esperer.webfluxserver.domain.auth.dto.SignInRequest
import esperer.webfluxserver.domain.auth.dto.SignUpRequest
import esperer.webfluxserver.domain.auth.dto.TokenResponse
import esperer.webfluxserver.domain.auth.dto.UserInfoResponse

interface AuthApi {
    suspend fun signUp(request: SignUpRequest): TokenResponse
    suspend fun signIn(request: SignInRequest): TokenResponse
    suspend fun getUserInfo(): UserInfoResponse
}
package esperer.webfluxserver.domain.auth.dto

import org.jetbrains.annotations.NotNull

data class SignInRequest(
    @field:NotNull
    val email: String,
    @field:NotNull
    val password: String
)
package esperer.webfluxserver.domain.auth.dto

import org.jetbrains.annotations.NotNull

data class SignUpRequest(
    @field:NotNull
    val email: String,
    @field:NotNull
    val password: String,
    @field:NotNull
    val name: String
)

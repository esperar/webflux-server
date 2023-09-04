package esperer.webfluxserver.domain.auth.dto

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: LocalDateTime,
    val refreshExp: LocalDateTime
)

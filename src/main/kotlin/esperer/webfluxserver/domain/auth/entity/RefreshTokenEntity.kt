package esperer.webfluxserver.domain.auth.entity

import org.springframework.data.redis.core.RedisHash
import java.util.UUID

data class RefreshTokenEntity(
    val token: String,
    val userId: UUID
)
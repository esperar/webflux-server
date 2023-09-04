package esperer.webfluxserver.global.security.token

import esperer.webfluxserver.global.security.SecurityProperties
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class JwtProvider(
    private val reactiveRedisOperations: ReactiveRedisOperations<String, Any>,
    private val securityProperties: SecurityProperties
) {

}
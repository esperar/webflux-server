package esperer.webfluxserver.global.security.token

import esperer.webfluxserver.domain.auth.dto.TokenResponse
import esperer.webfluxserver.domain.auth.exception.RefreshTokenSaveFailedException
import esperer.webfluxserver.global.security.SecurityProperties
import io.jsonwebtoken.Header.JWT_TYPE
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class JwtProvider(
    private val reactiveRedisOperations: ReactiveRedisOperations<String, Any>,
    private val securityProperties: SecurityProperties
) {

    companion object {
        const val ACCESS = "access"
        const val REFRESH = "refresh"
    }

    suspend fun getToken(userId: UUID) = TokenResponse(
        accessToken = createAccessToken(userId),
        refreshToken = createRefreshToken(userId),
        accessExp = nowPlusSecond(securityProperties.accessExp),
        refreshExp = nowPlusSecond(securityProperties.refreshExp)
    )

    private fun nowPlusSecond(tokenExpiredAt: Long) =
        LocalDateTime.now().withNano(0).plusSeconds(tokenExpiredAt)

    fun createAccessToken(userId: UUID): String =
        createToken(userId, ACCESS, securityProperties.accessExp)

    suspend fun createRefreshToken(userId: UUID): String{
        val refreshToken = createToken(userId, REFRESH, securityProperties.refreshExp)
        return saveRefreshToken(refreshToken)
    }

    private fun createToken(userId: UUID, tokenType: String, tokenExpiredAt: Long) =
        Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, securityProperties.secretKey)
            .setSubject(userId.toString())
            .setHeaderParam(JWT_TYPE, tokenType)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + tokenExpiredAt * 1000))
            .compact()

    private suspend fun saveRefreshToken(refreshToken: String): String {
        val isSaveSuccess = reactiveRedisOperations.opsForValue()
            .set(refreshToken, securityProperties.refreshExp).awaitSingle()

        if (!isSaveSuccess) {
            throw RefreshTokenSaveFailedException()
        }

        return refreshToken
    }
}
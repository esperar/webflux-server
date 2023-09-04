package esperer.webfluxserver.global.security.token

import esperer.webfluxserver.global.error.exception.ExpiredTokenException
import esperer.webfluxserver.global.error.exception.InternalServerException
import esperer.webfluxserver.global.error.exception.InvalidTokenException
import esperer.webfluxserver.global.security.SecurityProperties
import esperer.webfluxserver.global.security.principle.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtParser(
    private val securityProperties: SecurityProperties,
    private val authDetailsService: AuthDetailsService
) {

    suspend fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)

        val authDetails = authDetailsService.findByUsername(claims.subject).awaitSingle()
        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    private fun getClaims(token: String): Claims =
        try {
            Jwts.parser().setSigningKey(securityProperties.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is InvalidClaimException -> throw InvalidTokenException()
                is ExpiredJwtException -> throw ExpiredTokenException()
                else -> throw InternalServerException()
            }
        }
}
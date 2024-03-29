package esperer.webfluxserver.global.security

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
data class SecurityProperties(
    val accessExp: Long,
    val refreshExp: Long,
    val secretKey: String
)

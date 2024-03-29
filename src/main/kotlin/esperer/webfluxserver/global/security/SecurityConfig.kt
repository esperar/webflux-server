package esperer.webfluxserver.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    protected fun filterChain(http: ServerHttpSecurity): SecurityWebFilterChain =
        http
            .httpBasic { it.disable() }
            .formLogin { it.disable() }
            .csrf { it.disable() }
            .authorizeExchange { it
                .pathMatchers("/post").hasRole("ADMIN")
                .anyExchange().permitAll()
            }
            .build()

    @Bean
    protected fun passwordEncoder() = BCryptPasswordEncoder()
}
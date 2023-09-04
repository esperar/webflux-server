package esperer.webfluxserver.global.security.principle

import esperer.webfluxserver.domain.user.exception.UserNotFoundException
import esperer.webfluxserver.domain.user.repository.UserRepository
import kotlinx.coroutines.reactor.mono
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.UUID

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
) : ReactiveUserDetailsService {

    override fun findByUsername(username: String?): Mono<UserDetails> = mono {
        val user = userRepository.findById(UUID.fromString(username))
            ?: throw UserNotFoundException()
        return@mono AuthDetails(user)
    }

}
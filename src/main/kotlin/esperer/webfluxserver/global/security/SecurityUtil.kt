package esperer.webfluxserver.global.security

import esperer.webfluxserver.domain.user.entity.UserEntity
import esperer.webfluxserver.domain.user.exception.UserNotFoundException
import esperer.webfluxserver.domain.user.repository.UserRepository
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SecurityUtil(
    private val userRepository: UserRepository
) {

    suspend fun getCurrentUser(): UserEntity {
        val userId = ReactiveSecurityContextHolder.getContext().awaitSingle().authentication?.name
        return userRepository.findById(UUID.fromString(userId))
            ?: throw UserNotFoundException()
    }
}
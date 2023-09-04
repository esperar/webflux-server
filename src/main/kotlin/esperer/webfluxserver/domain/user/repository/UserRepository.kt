package esperer.webfluxserver.domain.user.repository

import esperer.webfluxserver.domain.user.entity.UserEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface UserRepository : CoroutineCrudRepository<UserEntity, UUID> {
    suspend fun existsByEmail(email: String): Boolean
    suspend fun findByEmail(email: String): UserEntity?
    override suspend fun findById(id: UUID): UserEntity?
}
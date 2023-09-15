package esperer.webfluxserver.domain.post.repository

import esperer.webfluxserver.domain.post.entity.PostEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface PostRepository : CoroutineCrudRepository<PostEntity, UUID>
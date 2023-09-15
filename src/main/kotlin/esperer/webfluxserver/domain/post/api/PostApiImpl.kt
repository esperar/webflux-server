package esperer.webfluxserver.domain.post.api

import esperer.webfluxserver.domain.post.dto.CreatePostRequest
import esperer.webfluxserver.domain.post.entity.PostEntity
import esperer.webfluxserver.domain.post.repository.PostRepository
import esperer.webfluxserver.global.security.SecurityUtils
import org.springframework.stereotype.Service

@Service
class PostApiImpl(
    private val postRepository: PostRepository,
    private val securityUtils: SecurityUtils
) : PostApi {

    override suspend fun createPost(request: CreatePostRequest) {
        val currentUser = securityUtils.getCurrentUser()

        val post = PostEntity(
            title = request.title,
            content = request.content,
            userId = currentUser.id
        )

        postRepository.save(post)
    }
}
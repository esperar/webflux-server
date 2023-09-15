package esperer.webfluxserver.domain.post.api

import esperer.webfluxserver.domain.post.dto.CreatePostRequest

interface PostApi {
    suspend fun createPost(request: CreatePostRequest)
}
package esperer.webfluxserver.domain.post.dto

data class CreatePostRequest(
    val title: String,
    val content: String
)

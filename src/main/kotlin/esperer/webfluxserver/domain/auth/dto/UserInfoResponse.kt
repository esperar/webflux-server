package esperer.webfluxserver.domain.auth.dto

import esperer.webfluxserver.domain.user.constant.Authority

data class UserInfoResponse(
    val email: String,
    val name: String,
    val authority: Authority
)

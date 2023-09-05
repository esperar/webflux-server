package esperer.webfluxserver.domain.auth.api

import esperer.webfluxserver.domain.auth.dto.SignInRequest
import esperer.webfluxserver.domain.auth.dto.SignUpRequest
import esperer.webfluxserver.domain.auth.dto.TokenResponse
import esperer.webfluxserver.domain.user.constant.Authority
import esperer.webfluxserver.domain.user.entity.UserEntity
import esperer.webfluxserver.domain.user.exception.UserAlreadyExistsException
import esperer.webfluxserver.domain.user.exception.UserNotFoundException
import esperer.webfluxserver.domain.user.repository.UserRepository
import esperer.webfluxserver.global.error.exception.UnAuthorizedException
import esperer.webfluxserver.global.security.token.JwtProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthApi(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtProvider
) {

    suspend fun signUp(request: SignUpRequest): TokenResponse {
        val isExists = userRepository.existsByEmail(request.email)

        if(isExists)
            throw UserAlreadyExistsException()

        val user = userRepository.save(
            UserEntity(
                email = request.email,
                password = passwordEncoder.encode(request.password),
                name = request.name,
                authority = Authority.ROLE_USER
            )
        )

        return jwtProvider.getToken(user.id)
    }

    suspend fun signIn(request: SignInRequest): TokenResponse {
        val user = userRepository.findByEmail(request.email)
            ?: throw UserNotFoundException()

        val isMatches = passwordEncoder.matches(user.password, request.password)

        if(isMatches)
            throw UnAuthorizedException()

        return jwtProvider.getToken(user.id)
    }

}
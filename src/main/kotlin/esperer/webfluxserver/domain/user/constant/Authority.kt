package esperer.webfluxserver.domain.user.constant

import org.springframework.security.core.GrantedAuthority

enum class Authority : GrantedAuthority {

    ROLE_USER, ROLE_ADMIN;

    override fun getAuthority(): String = name
}
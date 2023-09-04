package esperer.webfluxserver.global.security.principle

import esperer.webfluxserver.domain.user.entity.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: UserEntity
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf(user.authority)

    override fun getPassword(): String? = null

    override fun getUsername(): String = user.id.toString()

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}
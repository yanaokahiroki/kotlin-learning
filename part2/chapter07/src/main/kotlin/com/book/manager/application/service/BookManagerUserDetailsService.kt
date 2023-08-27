package com.book.manager.application.service

import com.book.manager.domain.enu.RoleType
import com.book.manager.domain.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class BookManagerUserDetailsService(
  private val authenticationService: AuthenticationService) : UserDetailsService {
  override fun loadUserByUsername(username: String): UserDetails {
    val user = authenticationService.findUser(username)

    return user?.let { BookManagerUserDetails(it) }
      ?: throw UsernameNotFoundException("The requested user is not found. (username=$username)")
  }

  data class BookManagerUserDetails(
    val id: Long,
    val email: String,
    val pass: String,
    val name: String,
    val roleType: RoleType
  ) : UserDetails {

    constructor(user: User) : this(
      id = user.id,
      email = user.email,
      pass = user.password,
      name = user.name,
      roleType = user.roleType
    )

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
      return AuthorityUtils.createAuthorityList(this.roleType.toString())
    }

    override fun getUsername(): String {
      return this.email
    }

    override fun getPassword(): String {
      return this.pass
    }

    override fun isAccountNonExpired(): Boolean {
      return true
    }

    override fun isAccountNonLocked(): Boolean {
      return true
    }

    override fun isCredentialsNonExpired(): Boolean {
      return true
    }

    override fun isEnabled(): Boolean {
      return true
    }
  }
}

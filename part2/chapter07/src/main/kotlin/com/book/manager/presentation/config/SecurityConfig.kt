package com.book.manager.presentation.config

import com.book.manager.domain.enu.RoleType
import com.book.manager.presentation.handler.BookManagerAccessDeniedHandler
import com.book.manager.presentation.handler.BookManagerAuthenticationEntryPoint
import com.book.manager.presentation.handler.BookManagerAuthenticationFailureHandler
import com.book.manager.presentation.handler.BookManagerAuthenticationSuccessHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

/**
 * Spring Security設定
 */
@Configuration
@EnableWebSecurity
class SecurityConfig {

  /**
   * パスワードエンコーダー
   *
   * @return PasswordEncoder
   */
  @Bean
  fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

  /**
   * Spring Securityの設定
   *
   * @param http HttpSecurity
   * @return SecurityFilterChain
   */
  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
    http
      .authorizeHttpRequests {
        it.requestMatchers("/login").permitAll()
          .requestMatchers("/admin/**").hasAuthority(RoleType.ADMIN.toString())
          .anyRequest().authenticated()
      }
      .csrf { it.disable() }
      .formLogin {
        it.loginProcessingUrl("/login")
          .usernameParameter("email")
          .passwordParameter("pass")
          .successHandler(BookManagerAuthenticationSuccessHandler())
          .failureHandler(BookManagerAuthenticationFailureHandler())
      }
      .exceptionHandling {
        it.authenticationEntryPoint(BookManagerAuthenticationEntryPoint())
          .accessDeniedHandler(BookManagerAccessDeniedHandler())
      }
      .cors { cors -> cors.configurationSource(corsConfigurationSource()) }

    return http.build()
  }

  /**
   * CORS設定
   *
   * @return CorsConfigurationSource
   */
  private fun corsConfigurationSource(): CorsConfigurationSource {
    val configuration = CorsConfiguration()
    configuration.addAllowedOrigin("http://localhost:8081")
    configuration.addAllowedHeader(CorsConfiguration.ALL)
    configuration.addAllowedMethod(CorsConfiguration.ALL)
    configuration.allowCredentials = true

    val corsConfigurationSource = UrlBasedCorsConfigurationSource()
    corsConfigurationSource.registerCorsConfiguration("/**", configuration)

    return corsConfigurationSource
  }
}

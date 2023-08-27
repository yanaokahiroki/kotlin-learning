package com.book.manager.presentation.handler

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler

/**
 * 認証成功ハンドラ
 */
class BookManagerAuthenticationSuccessHandler : AuthenticationSuccessHandler {
  override fun onAuthenticationSuccess(
    request: HttpServletRequest?,
    response: HttpServletResponse,
    authentication: Authentication
  ) {
    response.status = HttpServletResponse.SC_OK
  }
}

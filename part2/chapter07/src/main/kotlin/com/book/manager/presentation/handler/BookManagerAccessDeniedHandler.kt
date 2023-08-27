package com.book.manager.presentation.handler

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler

/**
 * アクセス拒否ハンドラ
 */
class BookManagerAccessDeniedHandler : AccessDeniedHandler {
  override fun handle(
    request: HttpServletRequest,
    response: HttpServletResponse,
    accessDeniedException: AccessDeniedException
  ) {
    response.status = HttpServletResponse.SC_FORBIDDEN
  }
}

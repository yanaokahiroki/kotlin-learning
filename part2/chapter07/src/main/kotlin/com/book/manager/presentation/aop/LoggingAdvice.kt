package com.book.manager.presentation.aop

import com.book.manager.application.service.BookManagerUserDetailsService
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class LoggingAdvice {
  companion object {
    private val log = org.slf4j.LoggerFactory.getLogger(LoggingAdvice::class.java)
  }

  @Before("execution(* com.book.manager.presentation.controller..*.*(..))")
  fun before(joinPoint: JoinPoint) {
    val user = SecurityContextHolder.getContext().authentication.principal as BookManagerUserDetailsService.BookManagerUserDetails
    log.info("Start: ${joinPoint.signature} userId=${user.id}")
    log.info("Class: ${joinPoint.target.javaClass}")
    log.info("Session: ${(RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request.session.id}")
  }

  @After("execution(* com.book.manager.presentation.controller..*.*(..))")
  fun after(joinPoint: JoinPoint) {
    val user = SecurityContextHolder.getContext().authentication.principal as BookManagerUserDetailsService.BookManagerUserDetails
    log.info("End: ${joinPoint.signature} userId=${user.id}")
  }

  @Around("execution(* com.book.manager.presentation.controller..*.*(..))")
  fun around(joinPoint: ProceedingJoinPoint): Any? {
    // 前処理
    val user = SecurityContextHolder.getContext().authentication.principal as BookManagerUserDetailsService.BookManagerUserDetails
    log.info("Start: ${joinPoint.signature} userId=${user.id}")

    // 本処理の実行
    val result = joinPoint.proceed()

    // 後処理
    log.info("End: ${joinPoint.signature} userId=${user.id}")

    // 本処理の結果を返却
    return result
  }

  @AfterReturning(pointcut = "execution(* com.book.manager.presentation.controller..*.*(..))", returning = "returnValue")
  fun afterReturning(joinPoint: JoinPoint, returnValue: Any?) {
    log.info("End: ${joinPoint.signature} returnValue=${returnValue}")
  }

  @AfterThrowing(pointcut = "execution(* com.book.manager.presentation.controller..*.*(..))", throwing = "e")
  fun afterThrowing(joinPoint: JoinPoint, e: Throwable) {
    log.error("Exception: ${e.javaClass} signature=${joinPoint.signature} message=${e.message}")
  }
}

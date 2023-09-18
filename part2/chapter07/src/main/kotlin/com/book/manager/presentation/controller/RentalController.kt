package com.book.manager.presentation.controller

import com.book.manager.application.service.BookManagerUserDetailsService
import com.book.manager.application.service.RentalService
import com.book.manager.presentation.form.RentalStartRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 貸出返却コントローラー
 *
 * @property rentalService 貸出返却サービス
 */
@RestController
@RequestMapping("api/rental")
@CrossOrigin(origins = ["http://localhost:8081"], allowCredentials = "true")
class RentalController(private val rentalService: RentalService) {

  @PostMapping("/start")
  fun startRental(@RequestBody request: RentalStartRequest) {
    val user = SecurityContextHolder.getContext().authentication.principal as BookManagerUserDetailsService.BookManagerUserDetails
    rentalService.startRental(bookId = request.bookId, userId = user.id)
  }
}

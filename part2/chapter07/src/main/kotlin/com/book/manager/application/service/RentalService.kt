package com.book.manager.application.service

import com.book.manager.domain.model.Rental
import com.book.manager.domain.repository.BookRepository
import com.book.manager.domain.repository.RentalRepository
import com.book.manager.domain.repository.UserRepository
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.time.LocalDateTime

@Service
class RentalService(
  private val userRepository: UserRepository,
  private val bookRepository: BookRepository,
  private val rentalRepository: RentalRepository
) {

  companion object {
    /** 貸出期間 */
    private const val RENTAL_TERM_DAYS = 14L
  }

  fun startRental(bookId: Long, userId: Long) {
    val user = userRepository.findByUserId(userId)
      ?: throw IllegalArgumentException("user not found. userId: $userId")
    val book = bookRepository.findWithRental(bookId)
      ?: throw IllegalArgumentException("book not found. bookId: $bookId")

    // 貸出中かどうかチェック
    if (book.isRental) {
      throw IllegalStateException("book is already rental. bookId: $bookId")
    }

    val rentalDateTime = LocalDateTime.now()
    val returnDeadline = rentalDateTime.plusDays(RENTAL_TERM_DAYS)
    val rental = Rental(
      bookId = bookId,
      userId = user.id,
      rentalDatetime = rentalDateTime,
      returnDeadline = returnDeadline
    )

    rentalRepository.startRental(rental)
  }
}

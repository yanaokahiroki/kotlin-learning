package com.book.manager.infrastructure.database.record

import java.time.LocalDate
import java.time.LocalDateTime

data class BookWithRentalRecord (
  val id: Long? = null,
  val title: String? = null,
  val author: String? = null,
  val releaseDate: LocalDate? = null,
  val userId: Long? = null,
  val rentalDatetime: LocalDateTime? = null,
  val rentalDeadline: LocalDateTime? = null
)

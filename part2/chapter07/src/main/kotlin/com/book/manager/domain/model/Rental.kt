package com.book.manager.domain.model

import java.time.LocalDateTime

/**
 * 貸出情報
 *
 * @property bookId 書籍ID
 * @property userId ユーザーID
 * @property rentalDatetime 貸出日時
 * @property returnDeadline 返却期限
 */
data class Rental(
  val bookId: Long,
  val userId: Long,
  val rentalDatetime: LocalDateTime,
  val returnDeadline: LocalDateTime
)

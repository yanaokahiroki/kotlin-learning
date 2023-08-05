package com.book.manager.domain.model

/**
 * 書籍の貸出情報
 *
 * @property book 書籍
 * @property rental 貸出情報
 */
data class BookWithRental(
  val book: Book,
  val rental: Rental?
) {
  val isRental: Boolean
    get() = rental != null
}

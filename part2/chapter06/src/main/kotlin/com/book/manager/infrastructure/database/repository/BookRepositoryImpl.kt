package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.Book
import com.book.manager.domain.model.BookWithRental
import com.book.manager.domain.model.Rental
import com.book.manager.domain.repository.BookRepository
import com.book.manager.infrastructure.database.mapper.BookWithRentalMapper
import com.book.manager.infrastructure.database.mapper.select
import com.book.manager.infrastructure.database.mapper.selectByPrimaryKey
import com.book.manager.infrastructure.database.record.BookWithRentalRecord
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl(
  private val bookWithRentalMapper: BookWithRentalMapper
) : BookRepository {
  override fun findAllWithRental(): List<BookWithRental> =
    bookWithRentalMapper.select().map { toBookWithRental(it) }

  override fun findWithRental(id: Long): BookWithRental? =
    bookWithRentalMapper.selectByPrimaryKey(id)?.let { toBookWithRental(it) }

  /**
   * BookWithRentalRecordをBookWithRentalに変換する
   *
   * @param record BookWithRentalRecord
   * @return BookWithRental
   */
  private fun toBookWithRental(record: BookWithRentalRecord): BookWithRental {
    val book = Book(
      id = record.id ?: throw IllegalStateException("id must not be null"),
      title = record.title ?: throw IllegalStateException("title must not be null"),
      author = record.author ?: throw IllegalStateException("author must not be null"),
      releaseDate = record.releaseDate ?: throw IllegalStateException("releaseDate must not be null")
    )

    val rental = record.userId?.let {
      Rental(
        bookId = record.id,
        userId = record.userId,
        rentalDatetime = record.rentalDatetime ?: throw IllegalStateException("rentalDatetime must not be null"),
        returnDeadline = record.rentalDeadline ?: throw IllegalStateException("rentalDeadline must not be null")
      )
    }

    return BookWithRental(book, rental)
  }
}

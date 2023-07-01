package com.book.manager.application.service

import com.book.manager.domain.model.BookWithRental
import com.book.manager.domain.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
  private val bookRepository: BookRepository
) {
  /**
   * 書籍と貸出情報の一覧を取得する
   *
   * @return 書籍と貸出情報の一覧
   */
  fun getBookWithRentalList(): List<BookWithRental> = bookRepository.findAllWithRental()

  /**
   * 書籍IDに紐づく書籍と貸出情報を取得する
   *
   * @param id 書籍ID
   * @return 書籍と貸出情報
   */
  fun getBookWithRental(id: Long): BookWithRental =
    bookRepository.findWithRental(id) ?: throw IllegalArgumentException("Book not found. id: $id")
}

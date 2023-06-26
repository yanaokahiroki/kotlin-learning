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
}

package com.book.manager.application.service

import com.book.manager.domain.model.Book
import com.book.manager.domain.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

/**
 * 管理者用書籍サービス
 */
@Service
class AdminBookService(private val bookRepository: BookRepository) {

  /**
   * 書籍を登録する
   *
   * @param book 書籍
   */
  @Transactional
  fun registerBook(book: Book) {
    bookRepository.findWithRental(book.id)?.let {
      throw IllegalArgumentException("Book already exists. id: ${book.id}")
    }

    bookRepository.register(book)
  }

  /**
   * 書籍を更新する
   *
   * @param id 書籍ID
   * @param title 書籍名
   * @param author 著者名
   * @param releaseDate 発売日
   */
  @Transactional
  fun updateBook(id: Long, title: String?, author: String?, releaseDate: LocalDate?) {
    bookRepository.findWithRental(id)
      ?: throw IllegalArgumentException("Book not found. id: $id")

    bookRepository.update(id, title, author, releaseDate)
  }

  /**
   * 書籍を削除する
   *
   * @param id 書籍ID
   */
  @Transactional
  fun deleteBook(id: Long) {
    bookRepository.findWithRental(id)
      ?: throw IllegalArgumentException("Book not found. id: $id")

    bookRepository.delete(id)
  }
}

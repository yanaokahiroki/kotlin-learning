package com.book.manager.application.service

import com.book.manager.domain.model.Book
import com.book.manager.domain.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class AdminBookService(private val bookRepository: BookRepository) {

  @Transactional
  fun registerBook(book: Book) {
    bookRepository.findWithRental(book.id)?.let {
      throw IllegalArgumentException("Book already exists. id: ${book.id}")
    }

    bookRepository.register(book)
  }

  @Transactional
  fun updateBook(id: Long, title: String?, author: String?, releaseDate: LocalDate?) {
    bookRepository.findWithRental(id)
      ?: throw IllegalArgumentException("Book not found. id: $id")

    bookRepository.update(id, title, author, releaseDate)
  }
}

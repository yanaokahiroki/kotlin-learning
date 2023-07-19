package com.book.manager.application.service

import com.book.manager.domain.model.Book
import com.book.manager.domain.repository.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminBookService(private val bookRepository: BookRepository) {

  @Transactional
  fun registerBook(book: Book) {
    bookRepository.findWithRental(book.id)?.let {
      throw IllegalArgumentException("Book already exists. id: ${book.id}")
    }

    bookRepository.register(book)
  }
}

package com.book.manager.presentation.controller

import com.book.manager.application.service.BookService
import com.book.manager.presentation.form.BookInfo
import com.book.manager.presentation.form.GetBookListResponse
import com.book.manager.presentation.form.GetBookResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/books")
@CrossOrigin(origins = ["http://localhost:8081"], allowCredentials = "true")
class BookController(
  private val bookService: BookService
) {

  /**
   * 書籍と貸出情報の一覧を取得する
   */
  @GetMapping
  fun getBookList(): GetBookListResponse {
    val bookInfoList = bookService.getBookWithRentalList().map { BookInfo(it) }
    return GetBookListResponse(bookInfoList)
  }

  /**
   * 書籍IDに紐づく書籍と貸出情報を取得する
   */
  @GetMapping("/{bookId}")
  fun getBookDetail(@PathVariable("bookId") bookId: Long): GetBookResponse {
    val book = bookService.getBookWithRental(bookId)
    return GetBookResponse(book)
  }
}

package com.book.manager.presentation.controller

import com.book.manager.application.service.BookService
import com.book.manager.presentation.form.BookInfo
import com.book.manager.presentation.form.GetBookListResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/books")
@CrossOrigin
class BookController(
  private val bookService: BookService
) {

  @GetMapping
  fun getBookList(): GetBookListResponse {
    val bookInfoList = bookService.getBookWithRentalList().map { BookInfo(it) }
    return GetBookListResponse(bookInfoList)
  }
}

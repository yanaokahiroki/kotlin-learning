package com.book.manager.presentation.controller

import com.book.manager.application.service.AdminBookService
import com.book.manager.domain.model.Book
import com.book.manager.presentation.form.RegisterBookRequest
import com.book.manager.presentation.form.UpdateBookRequest
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 管理者用書籍コントローラー
 */
@RestController
@RequestMapping("admin/books")
@CrossOrigin(origins = ["http://localhost:8081"], allowCredentials = "true")
class AdminBookController(private val adminBookService: AdminBookService) {

  /**
   * 書籍を登録する
   *
   * @param request 登録する書籍情報
   */
  @PostMapping("/register")
  fun registerBook(@RequestBody request: RegisterBookRequest) {
    adminBookService.registerBook(
      Book(
        id = request.id,
        title = request.title,
        author = request.author,
        releaseDate = request.releaseDate
      )
    )
  }

  /**
   * 書籍を更新する
   *
   * @param request 更新する書籍情報
   */
  @PostMapping("/update")
  fun updateBook(@RequestBody request: UpdateBookRequest) {
    adminBookService.updateBook(
      request.id,
      request.title,
      request.author,
      request.releaseDate
    )
  }

  /**
   * 書籍を削除する
   *
   * @param bookId 書籍ID
   */
  @DeleteMapping("/delete/{book_id}")
  fun deleteBook(@PathVariable("book_id") bookId: Long) {
    adminBookService.deleteBook(bookId)
  }
}

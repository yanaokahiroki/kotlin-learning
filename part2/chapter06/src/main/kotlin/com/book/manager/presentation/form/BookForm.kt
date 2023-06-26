package com.book.manager.presentation.form

import com.book.manager.domain.model.BookWithRental

data class GetBookListResponse(
  val bookList: List<BookInfo>
)

data class BookInfo(
  val id: Long,
  val title: String,
  val author: String,
  val isRental: Boolean
) {
  constructor(model: BookWithRental) : this(
    id = model.book.id,
    title = model.book.title,
    author = model.book.author,
    isRental = model.isRental
  )
}

package com.book.manager.domain.model

import java.time.LocalDate

/**
 * 書籍
 *
 * @property id 書籍ID
 * @property title 書籍名
 * @property author 著者名
 * @property releaseDate 発売日
 */
data class Book(
  val id: Long,
  val title: String,
  val author: String,
  val releaseDate: LocalDate
)

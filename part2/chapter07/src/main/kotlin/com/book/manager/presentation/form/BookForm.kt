package com.book.manager.presentation.form

import com.book.manager.domain.model.BookWithRental
import com.book.manager.domain.model.Rental
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * 書籍一覧取得レスポンス
 *
 * @property bookList 書籍リスト
 */
data class GetBookListResponse(
  val bookList: List<BookInfo>
)

/**
 * 書籍情報
 *
 * @property id 書籍ID
 * @property title 書籍名
 * @property author 著者名
 * @property isRental 貸出中かどうか
 */
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

/**
 * 書籍取得レスポンス
 *
 * @property id 書籍ID
 * @property title 書籍名
 * @property author 著者名
 * @property releaseDate 発売日
 * @property rentalInfo 貸出情報
 */
data class GetBookResponse(
  val id: Long,
  val title: String,
  val author: String,
  val releaseDate: LocalDate,
  val rentalInfo: RentalInfo?
) {
  constructor(model: BookWithRental) : this(
    id = model.book.id,
    title = model.book.title,
    author = model.book.author,
    releaseDate = model.book.releaseDate,
    rentalInfo = model.rental?.let { RentalInfo(it) }
  )
}

/**
 * 貸出情報
 *
 * @property userId ユーザーID
 * @property rentalDatetime 貸出日時
 * @property returnDeadline 返却期限
 */
data class RentalInfo(
  val userId: Long,
  val rentalDatetime: LocalDateTime,
  val returnDeadline: LocalDateTime
) {
  constructor(rental: Rental) : this(
    userId = rental.userId,
    rentalDatetime = rental.rentalDatetime,
    returnDeadline = rental.returnDeadline
  )
}

/**
 * 書籍登録リクエスト
 *
 * @property id 書籍ID
 * @property title 書籍名
 * @property author 著者名
 * @property releaseDate 発売日
 */
data class RegisterBookRequest(
  val id: Long,
  val title: String,
  val author: String,
  val releaseDate: LocalDate
)

/**
 * 書籍更新リクエスト
 *
 * @property id 書籍ID
 * @property title 書籍名
 * @property author 著者名
 * @property releaseDate 発売日
 */
data class UpdateBookRequest(
  val id: Long,
  val title: String?,
  val author: String?,
  val releaseDate: LocalDate?
)

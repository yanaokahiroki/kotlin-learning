package com.book.manager.infrastructure.database.mapper

import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.author
import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.id
import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.releaseDate
import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.title
import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.bookId
import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.rentalDatetime
import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.returnDeadline
import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.userId
import com.book.manager.infrastructure.database.record.BookWithRentalRecord
import org.mybatis.dynamic.sql.util.kotlin.spring.select

private val columnList = listOf(
  id,
  title,
  author,
  releaseDate,
  userId,
  rentalDatetime,
  returnDeadline
)

fun BookWithRentalMapper.select(): List<BookWithRentalRecord> {
  val selectStatement = select(columnList) {
    from(BooksDynamicSqlSupport.books, "b")
    leftJoin(RentalsDynamicSqlSupport.rentals, "r") {
      on(id) equalTo bookId
    }
  }

  return selectMany(selectStatement)
}

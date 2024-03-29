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
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select

private val columnList = listOf(
  id,
  title,
  author,
  releaseDate,
  userId,
  rentalDatetime,
  returnDeadline
)


/**
 * 書籍と貸出情報の一覧を取得する
 *
 * @return 書籍と貸出情報の一覧
 */
fun BookWithRentalMapper.select(): List<BookWithRentalRecord> {
  val selectStatement = select(columnList) {
    from(BooksDynamicSqlSupport.books, "b")
    leftJoin(RentalsDynamicSqlSupport.rentals, "r") {
      on(id) equalTo bookId
    }
  }

  return selectMany(selectStatement)
}

/**
 * 書籍と貸出情報を取得する
 *
 * @param id_ 書籍ID
 * @return 書籍と貸出情報
 */
fun BookWithRentalMapper.selectByPrimaryKey(id_: Long): BookWithRentalRecord? {
  val selectStatement = select(columnList) {
    from(BooksDynamicSqlSupport.books, "b")
    leftJoin(RentalsDynamicSqlSupport.rentals, "r") {
      on(id) equalTo bookId
    }
    where { id isEqualTo id_ }
  }

  return selectOne(selectStatement)
}

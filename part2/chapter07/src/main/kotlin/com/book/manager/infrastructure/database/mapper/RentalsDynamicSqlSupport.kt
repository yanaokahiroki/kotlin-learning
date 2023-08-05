/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object RentalsDynamicSqlSupport {
    val rentals = Rentals()

    val bookId = rentals.bookId

    val userId = rentals.userId

    val rentalDatetime = rentals.rentalDatetime

    val returnDeadline = rentals.returnDeadline

    class Rentals : AliasableSqlTable<Rentals>("rentals", ::Rentals) {
        val bookId = column<Long>(name = "book_id", jdbcType = JDBCType.BIGINT)

        val userId = column<Long>(name = "user_id", jdbcType = JDBCType.BIGINT)

        val rentalDatetime = column<LocalDateTime>(name = "rental_datetime", jdbcType = JDBCType.TIMESTAMP)

        val returnDeadline = column<LocalDateTime>(name = "return_deadline", jdbcType = JDBCType.TIMESTAMP)
    }
}
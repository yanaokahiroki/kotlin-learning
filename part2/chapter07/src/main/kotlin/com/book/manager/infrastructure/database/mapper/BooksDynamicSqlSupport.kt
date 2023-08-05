/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDate
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object BooksDynamicSqlSupport {
    val books = Books()

    val id = books.id

    val title = books.title

    val author = books.author

    val releaseDate = books.releaseDate

    class Books : AliasableSqlTable<Books>("books", ::Books) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val title = column<String>(name = "title", jdbcType = JDBCType.VARCHAR)

        val author = column<String>(name = "author", jdbcType = JDBCType.VARCHAR)

        val releaseDate = column<LocalDate>(name = "release_date", jdbcType = JDBCType.DATE)
    }
}
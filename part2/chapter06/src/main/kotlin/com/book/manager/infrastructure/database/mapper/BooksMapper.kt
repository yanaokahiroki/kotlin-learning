/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.author
import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.books
import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.id
import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.releaseDate
import com.book.manager.infrastructure.database.mapper.BooksDynamicSqlSupport.title
import com.book.manager.infrastructure.database.record.Books
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultiple
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface BooksMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Books>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="BooksResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        Result(column="author", property="author", jdbcType=JdbcType.VARCHAR),
        Result(column="release_date", property="releaseDate", jdbcType=JdbcType.DATE)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Books>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("BooksResult")
    fun selectOne(selectStatement: SelectStatementProvider): Books?
}

fun BooksMapper.count(completer: CountCompleter) =
    countFrom(this::count, books, completer)

fun BooksMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, books, completer)

fun BooksMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where { id isEqualTo id_ }
    }

fun BooksMapper.insert(row: Books) =
    insert(this::insert, row, books) {
        map(id) toProperty "id"
        map(title) toProperty "title"
        map(author) toProperty "author"
        map(releaseDate) toProperty "releaseDate"
    }

fun BooksMapper.insertMultiple(records: Collection<Books>) =
    insertMultiple(this::insertMultiple, records, books) {
        map(id) toProperty "id"
        map(title) toProperty "title"
        map(author) toProperty "author"
        map(releaseDate) toProperty "releaseDate"
    }

fun BooksMapper.insertMultiple(vararg records: Books) =
    insertMultiple(records.toList())

fun BooksMapper.insertSelective(row: Books) =
    insert(this::insert, row, books) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(title).toPropertyWhenPresent("title", row::title)
        map(author).toPropertyWhenPresent("author", row::author)
        map(releaseDate).toPropertyWhenPresent("releaseDate", row::releaseDate)
    }

private val columnList = listOf(id, title, author, releaseDate)

fun BooksMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, books, completer)

fun BooksMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, books, completer)

fun BooksMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, books, completer)

fun BooksMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun BooksMapper.update(completer: UpdateCompleter) =
    update(this::update, books, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Books) =
    apply {
        set(id) equalToOrNull row::id
        set(title) equalToOrNull row::title
        set(author) equalToOrNull row::author
        set(releaseDate) equalToOrNull row::releaseDate
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Books) =
    apply {
        set(id) equalToWhenPresent row::id
        set(title) equalToWhenPresent row::title
        set(author) equalToWhenPresent row::author
        set(releaseDate) equalToWhenPresent row::releaseDate
    }

fun BooksMapper.updateByPrimaryKey(row: Books) =
    update {
        set(title) equalToOrNull row::title
        set(author) equalToOrNull row::author
        set(releaseDate) equalToOrNull row::releaseDate
        where { id isEqualTo row.id!! }
    }

fun BooksMapper.updateByPrimaryKeySelective(row: Books) =
    update {
        set(title) equalToWhenPresent row::title
        set(author) equalToWhenPresent row::author
        set(releaseDate) equalToWhenPresent row::releaseDate
        where { id isEqualTo row.id!! }
    }
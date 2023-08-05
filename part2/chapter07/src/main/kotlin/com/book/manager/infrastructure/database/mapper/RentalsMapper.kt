/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.bookId
import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.rentalDatetime
import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.rentals
import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.returnDeadline
import com.book.manager.infrastructure.database.mapper.RentalsDynamicSqlSupport.userId
import com.book.manager.infrastructure.database.record.Rentals
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
interface RentalsMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Rentals>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="RentalsResult", value = [
        Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT, id=true),
        Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        Result(column="rental_datetime", property="rentalDatetime", jdbcType=JdbcType.TIMESTAMP),
        Result(column="return_deadline", property="returnDeadline", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Rentals>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("RentalsResult")
    fun selectOne(selectStatement: SelectStatementProvider): Rentals?
}

fun RentalsMapper.count(completer: CountCompleter) =
    countFrom(this::count, rentals, completer)

fun RentalsMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, rentals, completer)

fun RentalsMapper.deleteByPrimaryKey(bookId_: Long) =
    delete {
        where { bookId isEqualTo bookId_ }
    }

fun RentalsMapper.insert(row: Rentals) =
    insert(this::insert, row, rentals) {
        map(bookId) toProperty "bookId"
        map(userId) toProperty "userId"
        map(rentalDatetime) toProperty "rentalDatetime"
        map(returnDeadline) toProperty "returnDeadline"
    }

fun RentalsMapper.insertMultiple(records: Collection<Rentals>) =
    insertMultiple(this::insertMultiple, records, rentals) {
        map(bookId) toProperty "bookId"
        map(userId) toProperty "userId"
        map(rentalDatetime) toProperty "rentalDatetime"
        map(returnDeadline) toProperty "returnDeadline"
    }

fun RentalsMapper.insertMultiple(vararg records: Rentals) =
    insertMultiple(records.toList())

fun RentalsMapper.insertSelective(row: Rentals) =
    insert(this::insert, row, rentals) {
        map(bookId).toPropertyWhenPresent("bookId", row::bookId)
        map(userId).toPropertyWhenPresent("userId", row::userId)
        map(rentalDatetime).toPropertyWhenPresent("rentalDatetime", row::rentalDatetime)
        map(returnDeadline).toPropertyWhenPresent("returnDeadline", row::returnDeadline)
    }

private val columnList = listOf(bookId, userId, rentalDatetime, returnDeadline)

fun RentalsMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, rentals, completer)

fun RentalsMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, rentals, completer)

fun RentalsMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, rentals, completer)

fun RentalsMapper.selectByPrimaryKey(bookId_: Long) =
    selectOne {
        where { bookId isEqualTo bookId_ }
    }

fun RentalsMapper.update(completer: UpdateCompleter) =
    update(this::update, rentals, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Rentals) =
    apply {
        set(bookId) equalToOrNull row::bookId
        set(userId) equalToOrNull row::userId
        set(rentalDatetime) equalToOrNull row::rentalDatetime
        set(returnDeadline) equalToOrNull row::returnDeadline
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Rentals) =
    apply {
        set(bookId) equalToWhenPresent row::bookId
        set(userId) equalToWhenPresent row::userId
        set(rentalDatetime) equalToWhenPresent row::rentalDatetime
        set(returnDeadline) equalToWhenPresent row::returnDeadline
    }

fun RentalsMapper.updateByPrimaryKey(row: Rentals) =
    update {
        set(userId) equalToOrNull row::userId
        set(rentalDatetime) equalToOrNull row::rentalDatetime
        set(returnDeadline) equalToOrNull row::returnDeadline
        where { bookId isEqualTo row.bookId!! }
    }

fun RentalsMapper.updateByPrimaryKeySelective(row: Rentals) =
    update {
        set(userId) equalToWhenPresent row::userId
        set(rentalDatetime) equalToWhenPresent row::rentalDatetime
        set(returnDeadline) equalToWhenPresent row::returnDeadline
        where { bookId isEqualTo row.bookId!! }
    }
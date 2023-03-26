/*
 * Auto-generated file. Created by MyBatis Generator
 */
package database

import database.Users
import database.UsersDynamicSqlSupport.age
import database.UsersDynamicSqlSupport.id
import database.UsersDynamicSqlSupport.name
import database.UsersDynamicSqlSupport.profile
import database.UsersDynamicSqlSupport.users
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
interface UsersMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Users>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="UsersResult", value = [
        Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        Result(column="profile", property="profile", jdbcType=JdbcType.VARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Users>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("UsersResult")
    fun selectOne(selectStatement: SelectStatementProvider): Users?
}

fun UsersMapper.count(completer: CountCompleter) =
    countFrom(this::count, users, completer)

fun UsersMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, users, completer)

fun UsersMapper.deleteByPrimaryKey(id_: Int) =
    delete {
        where { id isEqualTo id_ }
    }

fun UsersMapper.insert(row: Users) =
    insert(this::insert, row, users) {
        map(id) toProperty "id"
        map(name) toProperty "name"
        map(age) toProperty "age"
        map(profile) toProperty "profile"
    }

fun UsersMapper.insertMultiple(records: Collection<Users>) =
    insertMultiple(this::insertMultiple, records, users) {
        map(id) toProperty "id"
        map(name) toProperty "name"
        map(age) toProperty "age"
        map(profile) toProperty "profile"
    }

fun UsersMapper.insertMultiple(vararg records: Users) =
    insertMultiple(records.toList())

fun UsersMapper.insertSelective(row: Users) =
    insert(this::insert, row, users) {
        map(id).toPropertyWhenPresent("id", row::id)
        map(name).toPropertyWhenPresent("name", row::name)
        map(age).toPropertyWhenPresent("age", row::age)
        map(profile).toPropertyWhenPresent("profile", row::profile)
    }

private val columnList = listOf(id, name, age, profile)

fun UsersMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, users, completer)

fun UsersMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, users, completer)

fun UsersMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, users, completer)

fun UsersMapper.selectByPrimaryKey(id_: Int) =
    selectOne {
        where { id isEqualTo id_ }
    }

fun UsersMapper.update(completer: UpdateCompleter) =
    update(this::update, users, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Users) =
    apply {
        set(id) equalToOrNull row::id
        set(name) equalToOrNull row::name
        set(age) equalToOrNull row::age
        set(profile) equalToOrNull row::profile
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Users) =
    apply {
        set(id) equalToWhenPresent row::id
        set(name) equalToWhenPresent row::name
        set(age) equalToWhenPresent row::age
        set(profile) equalToWhenPresent row::profile
    }

fun UsersMapper.updateByPrimaryKey(row: Users) =
    update {
        set(name) equalToOrNull row::name
        set(age) equalToOrNull row::age
        set(profile) equalToOrNull row::profile
        where { id isEqualTo row.id!! }
    }

fun UsersMapper.updateByPrimaryKeySelective(row: Users) =
    update {
        set(name) equalToWhenPresent row::name
        set(age) equalToWhenPresent row::age
        set(profile) equalToWhenPresent row::profile
        where { id isEqualTo row.id!! }
    }
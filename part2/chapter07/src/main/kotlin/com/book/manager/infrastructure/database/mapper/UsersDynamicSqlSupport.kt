/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import com.book.manager.domain.enu.RoleType
import java.sql.JDBCType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UsersDynamicSqlSupport {
    val users = Users()

    val id = users.id

    val email = users.email

    val password = users.password

    val name = users.name

    val roleType = users.roleType

    class Users : AliasableSqlTable<Users>("users", ::Users) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val email = column<String>(name = "email", jdbcType = JDBCType.VARCHAR)

        val password = column<String>(name = "password", jdbcType = JDBCType.VARCHAR)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)

        val roleType = column<RoleType>(name = "role_type", jdbcType = JDBCType.CHAR, typeHandler = "org.apache.ibatis.type.EnumTypeHandler")
    }
}
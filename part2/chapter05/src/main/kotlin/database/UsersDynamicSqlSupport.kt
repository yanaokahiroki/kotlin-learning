/*
 * Auto-generated file. Created by MyBatis Generator
 */
package database

import java.sql.JDBCType
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UsersDynamicSqlSupport {
    val users = Users()

    val id = users.id

    val name = users.name

    val age = users.age

    val profile = users.profile

    class Users : AliasableSqlTable<Users>("users", ::Users) {
        val id = column<Int>(name = "id", jdbcType = JDBCType.INTEGER)

        val name = column<String>(name = "name", jdbcType = JDBCType.VARCHAR)

        val age = column<Int>(name = "age", jdbcType = JDBCType.INTEGER)

        val profile = column<String>(name = "profile", jdbcType = JDBCType.VARCHAR)
    }
}
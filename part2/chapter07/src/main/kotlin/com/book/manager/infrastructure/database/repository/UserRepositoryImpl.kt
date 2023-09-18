package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.User
import com.book.manager.domain.repository.UserRepository
import com.book.manager.infrastructure.database.mapper.UsersDynamicSqlSupport
import com.book.manager.infrastructure.database.mapper.UsersMapper
import com.book.manager.infrastructure.database.mapper.selectByPrimaryKey
import com.book.manager.infrastructure.database.mapper.selectOne
import com.book.manager.infrastructure.database.record.Users
import org.springframework.stereotype.Repository

/**
 * ユーザーリポジトリの実装クラス
 *
 * @property usersMapper ユーザーマッパー
 */
@Repository
class UserRepositoryImpl(private val usersMapper: UsersMapper) : UserRepository {

  override fun findByEmail(email: String): User? {
    val record = usersMapper.selectOne {
      where {
        UsersDynamicSqlSupport.email isEqualTo email
      }
    }

    return record?.let {
      toModel(it)
    }
  }

  override fun findByUserId(userId: Long): User? {
    val record = usersMapper.selectByPrimaryKey(userId)
    return record?.let { toModel(it) }
  }

  /**
   * レコードをモデルに変換する
   *
   * @param record ユーザーレコード
   * @return ユーザーモデル
   */
  private fun toModel(record: Users): User =
    User(
      id = record.id!!,
      email = record.email!!,
      password = record.password!!,
      name = record.name!!,
      roleType = record.roleType!!
    )
}

package com.book.manager.domain.repository

import com.book.manager.domain.model.User

/**
 * ユーザーリポジトリ
 */
interface UserRepository {

  /**
   * ユーザー情報を取得する
   *
   * @param email メールアドレス
   * @return ユーザー情報
   */
  fun findByEmail(email: String): User?

  /**
   * ユーザー情報を取得する
   *
   * @param userId ユーザーID
   * @return ユーザー情報
   */
  fun findByUserId(userId: Long): User?
}

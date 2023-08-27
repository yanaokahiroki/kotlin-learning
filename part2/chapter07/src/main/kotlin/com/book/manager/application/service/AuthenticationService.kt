package com.book.manager.application.service

import com.book.manager.domain.model.User
import com.book.manager.domain.repository.UserRepository
import org.springframework.stereotype.Service

/**
 * 認証サービス
 *
 * @property userRepository ユーザーリポジトリ
 */
@Service
class AuthenticationService(private val userRepository: UserRepository) {

  /**
   * ユーザー情報を取得する
   *
   * @param email メールアドレス
   * @return ユーザー情報
   */
  fun findUser(email: String): User? = userRepository.findByEmail(email)
}

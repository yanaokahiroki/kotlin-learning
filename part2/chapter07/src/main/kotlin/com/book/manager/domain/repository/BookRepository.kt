package com.book.manager.domain.repository

import com.book.manager.domain.model.Book
import com.book.manager.domain.model.BookWithRental
import java.time.LocalDate

/**
 * 書籍リポジトリ
 */
interface BookRepository {

  /**
   * 書籍と貸出情報の一覧を取得する
   *
   * @return 書籍と貸出情報リスト
   */
  fun findAllWithRental(): List<BookWithRental>

  /**
   * 書籍IDに紐づく書籍と貸出情報を取得する
   *
   * @param id 書籍ID
   * @return 書籍と貸出情報
   */
  fun findWithRental(id: Long): BookWithRental?

  /**
   * 書籍を登録する
   *
   * @param book 書籍
   * @return 登録した書籍のID
   */
  fun register(book: Book): Int

  /**
   * 書籍を更新する
   *
   * @param id 書籍ID
   * @param title 書籍名
   * @param author 著者名
   * @param releaseDate 発売日
   */
  fun update(id: Long, title: String?, author: String?, releaseDate: LocalDate?)

  /**
   * 書籍を削除する
   *
   * @param id 書籍ID
   */
  fun delete(id: Long)
}

package com.book.manager.domain.model

import com.book.manager.domain.enu.RoleType

data class User(
  val id: Long,
  val email: String,
  val password: String,
  val name: String,
  val roleType: RoleType
)

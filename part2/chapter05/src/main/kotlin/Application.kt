import database.*

fun main() {
  multipleInsertExample()
}

fun selectExample() {
  val sqlSession = MybatisFactory().createMybatisSessionFactory().openSession()

  // useメソッドは中身の処理が完了するとセッションをクローズする
  sqlSession.use {
    val mapper = it.getMapper(UsersMapper::class.java)
    val user =  mapper.selectByPrimaryKey(100)
    println(user)
  }
}

fun selectWhereExample() {
  val sqlSession = MybatisFactory().createMybatisSessionFactory().openSession()

  sqlSession.use {
    val mapper = it.getMapper(UsersMapper::class.java)
    val userList = mapper.select{
      where {UsersDynamicSqlSupport.users.name isEqualTo  "Saburo"}
    }

    println(userList)
  }
}

fun selectWhereExample2() {
  val sqlSession = MybatisFactory().createMybatisSessionFactory().openSession()

  sqlSession.use {
    val mapper = it.getMapper(UsersMapper::class.java)
    val userList = mapper.select {
      where { UsersDynamicSqlSupport.users.age isGreaterThanOrEqualTo 25 }
    }

    println(userList)
  }
}

fun selectCountExample() {
  val sqlSession = MybatisFactory().createMybatisSessionFactory().openSession()

  sqlSession.use {
    val mapper = it.getMapper(UsersMapper::class.java)
    val userCount = mapper.count {
      where { UsersDynamicSqlSupport.users.age isGreaterThanOrEqualTo 25 }
    }

    println(userCount)
  }
}

fun selectCountExample2() {
  val sqlSession = MybatisFactory().createMybatisSessionFactory().openSession()

  sqlSession.use {
    val mapper = it.getMapper(UsersMapper::class.java)
    val userCount = mapper.count{ allRows() }

    println(userCount)
  }
}

fun insertExample() {
  val sqlSession = MybatisFactory().createMybatisSessionFactory().openSession()

  sqlSession.use {
    val mapper = it.getMapper(UsersMapper::class.java)
    val user = Users(103, "Shiro", 18, "Hello")
    val count = mapper.insert(user)
    it.commit()
    println(count)
  }
}

fun multipleInsertExample() {
  val sqlSession = MybatisFactory().createMybatisSessionFactory().openSession()

  sqlSession.use {
    val mapper = it.getMapper(UsersMapper::class.java)
    val user1 = Users(104, "Shiro", 18, "Hello")
    val user2 = Users(105, "Shiro", 18, "Hello")
    val user3 = Users(106, "Shiro", 18, "Hello")
    val count = mapper.insertMultiple(user1, user2, user3)
    it.commit()
    println(count)
  }
}

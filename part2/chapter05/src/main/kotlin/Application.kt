import database.UsersDynamicSqlSupport
import database.UsersMapper
import database.select
import database.selectByPrimaryKey

fun main() {
  selectWhereExample2()
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

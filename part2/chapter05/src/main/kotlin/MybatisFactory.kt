import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder

class MybatisFactory {

  /**
   * Mybatisの設定ファイルを読み込みDBのセッション作成用オブジェクトを生成する
   *
   * @return DBのセッション作成用オブジェクト
   */
  fun createMybatisSessionFactory(): SqlSessionFactory {
    val resource = "mybatis-config.xml"
    // Mybatisの設定ファイルを読み込む
    val inputStream = Resources.getResourceAsStream(resource)

    return SqlSessionFactoryBuilder().build(inputStream)
  }
}

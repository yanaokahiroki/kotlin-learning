fun main() {
  printUserInfo(1)
  printUserInfo(2, "Test")
  user8Test()
  user9Test()
}

/**
 * if文, while文はそれぞれ式として使うことができる
 *
 * @param num 数値
 */
fun printOddOrEvenNumberText(num: Int) {
  val text = if (num % 2 ==1) {
    "奇数"
  } else {
    "偶数"
  }

  println(text)
}

/**
 * 1行で書くこともできる
 * KotlinにはJavaにあるような3項演算子はない
 *
 * @param num 数値
 */
fun printOddOrEvenNumberTextSimpler(num: Int) {
  val text = if (num % 2 ==1) "奇数" else "偶数"
  println(text)
}

fun getOddOrEvenNumberText(num: Int): String {
  if (num % 2 == 1) {
    return "奇数"
  } else {
    return "偶数"
  }
}

/**
 * これはJavaでも3項演算子を使えば同じようにできる
 *
 * @param num 数値
 * @return numを2で割った余りが1なら奇数, 1でないなら偶数
 */
fun getOddOrEvenNumberTextSimpler(num: Int): String {
  return if (num % 2 == 1) "奇数" else "偶数"
}

fun printNumText(num: Int) {
  val text = when (num) {
    100 -> "100です！"
    200 -> "200です！"
    else -> "undefined value"
  }
  println(text)
}

/**
 * プロパティの定義でgetterとsetterが不要になる
 * Javaではlombokの@Getterや@Setterなどでコードを省略していた
 *
 */
class User1 {
  /**
   * 名前
   * <code>var<code>で定義するとgetterとsetterどちらも内部的に生成されている
   */
  var name: String = ""
}

/**
 * valで定義するとgetterだけ生成される
 * そのためインスタンス生成以降、変更させないようにするためにはプロパティをvalで定義する
 *
 * @param id ID
 */
class User2(id: Int) {
  val id:Int = id
  var name: String = ""
}

/**
 * lateinit
 *
 * val, varによるプロパティ定義では必ず初期値を設定する必要がある
 * しかし場合によってはインスタンス生成後に値を設定したいこともある
 *
 * そのようなときはlateinitと呼ばれる遅延初期化プロパティにする
 * lateinitはインスタンス生成後に値を書き換えるためvarでのみ使える
 * 後から必ず値を設定する必要があるため設定する前にgetterを呼び出すと実行時エラーになる
 *
 */
class User3 {
  lateinit var name: String
}

/**
 * 拡張プロパティでgetter, setterの処理を拡張する
 *
 * 内部的に生成していたgetter, setterを拡張して独自処理を書ける
 *
 */
class User4 {
  /**
   * nameのsetterを拡張
   * 空文字なら"Kotlin"そうでないなら設定されている値
   */
  var name: String = ""
    set(value) {
      field = if (value == "") {
        "Kotlin"
      } else {
        value
      }
    }

  /**
   * isValidNameというプロパティのgetterを拡張
   * User4のインスタンスを生成してからisValidNameを呼び出すとget()が呼ばれる
   * 名前が空文字ではないかを判定する
   */
  val isValidName: Boolean
    get() = name != ""
}

fun user(){
  val user = User1()
  user.name = "Test"
  println(user.name)

  val user2 = User2(100)
  user2.name = "Test2"
  println(user2.id)

  val user3 = User3()
  // kotlin.UninitializedPropertyAccessException: lateinit property name has not been initialized
  //  println(user3.name) 実行時にエラー

  user3.name = "Test3"
  println(user.name)

  val user4 = User4()
  user4.name = ""
  println(user4.name) // Kotlin
  user4.name = "Test4"
  println(user4.name) // Test4
  println(user4.isValidName)
}


/**
 * Data Class
 *
 * クラス名の前にdata classをつけるだけでデータクラスになる
 * これだけで下記の関数が使える
 *
 * * getter, setter(val定義ならgetterのみ)
 * * equals
 * * hashCode
 * * toString
 * * componentN
 * * copy
 *
 */
data class User7(val id: Int, var name: String)

fun dataClass() {
  val user7 = User7(1, "Test1")
  user7.name = "Kotlin"
  println(user7.name)

  val user = User7(2, "Test")
  val copyUser = user.copy(id = 3, name = "Copied")
  println(copyUser.toString())
}

/**
 * Default arguments
 *
 * 関数にデフォルト引数を設定できる
 * デフォルト引数は呼び出し時にその引数が省略された場合にデフォルトで使用される
 *
 * @param id ID
 * @param name 名前
 */
fun printUserInfo(id: Int, name: String = "Default name"){
  println("id=$id name=$name")
}

/**
 * デフォルト引数はコンストラクタにも使用できる
 *
 * @property id ID
 * @property name 名前
 */
data class User8(val id: Int, val name: String = "Default name")

fun user8Test() {
  val user = User8(1)
  println(user.toString())
}

/**
 * Named arguments
 *
 * 2番目の引数nameだけを省略して呼び出す
 * プロパティ名 = 値という形式で呼び出す
 *
 * @property id ID
 * @property name 名前
 * @property age 年齢
 */
data class User9(val id: Int, val name: String = "Default name", val age: Int)

fun user9Test() {
  val user = User9(id = 1, age = 25)
  println(user.toString())
}

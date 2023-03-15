fun main() {
  operatorExample()
}

/**
 * if文, while文はそれぞれ式として使うことができる
 *
 * @param num 数値
 */
fun printOddOrEvenNumberText(num: Int) {
  val text = if (num % 2 == 1) {
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
  val text = if (num % 2 == 1) "奇数" else "偶数"
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
  val id: Int = id
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

fun user() {
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
fun printUserInfo(id: Int, name: String = "Default name") {
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

/**
 * 関数型
 * Int型の引数を2つ受け取りInt型の戻り値を返す
 * 戻り値がない場合にはUnit型を返す
 * 関数を値として書くのを関数リテラル
 *
 */
fun functionTest() {
  val calc: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 + num2 }
  println(calc(10, 5))

  //  関数リテラルは型推論が効くので型を省略できる
  val calcV2: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }
  println(calcV2(10, 5))

  // 引数が1つなら引数名も省略できる
  // その場合には暗黙的にitが使われる
  val squared: (Int) -> Int = { it * it }
  println(squared(2))

  // Anonymous functions 無名関数
  val squaredV2: (Int) -> Int = fun(num: Int): Int { return num * num }
  println(squaredV2(2))
}

/**
 * Higher-order functions
 *
 *高階関数は関数型のオブジェクトを引数に受け取る関数
 *
 * @param num1
 * @param num2
 * @param calc
 */
fun printCalcResult(num1: Int, num2: Int, calc: (Int, Int) -> Int) {
  val result = calc(num1, num2)
  println(result)
}

/**
 * Type aliases
 *
 * タイプエイリアスは関数型を使い回すときに有用
 * 関数型に名前をつけておけるからあとは使うときに呼び出せばいい
 *
 */
typealias Calc = (Int, Int) -> Int

fun printCalcResultV2(num1: Int, num2: Int, calc: Calc) {
  val result = calc(num1, num2)
  println(result)
}

/**
 * Extension functions
 *
 * 拡張関数は既存のクラスに関数を追加したかのような処理を記述できる
 *
 * @return
 */
fun Int.square(): Int = this * this

/**
 * Scope functions
 * スコープ関数
 *
 * with：複数の処理をまとめて行う
 * 第1引数はレシーバーとなるオブジェクト(レシーバーオブジェクト)、第2引数はレシーバーのオブジェクトを処理し任意の型を返す関数を渡す
 *
 * この例では
 */
fun withExample() {
  val list = mutableListOf<Int>()
  for (i in 1..10) {
    if (i % 2 == 1) list.add(i)
  }
  // joinToStingでListなどのコレクション要素を指定の文字列をseparatorのして文字列にする
  val oddNumbers = list.joinToString(separator = " ")
  println(oddNumbers)

  val oddNumbersWith = with(mutableListOf<Int>()) {
    for (i in 1..10) {
      if (i % 2 == 1) this.add(i)
    }
    this.joinToString(separator = " ")
  }
  println(oddNumbersWith)
}

/**
 * Scope functions
 * スコープ関数
 *
 * run：withに似ている、レシーバーオブジェクトを引数に取るのではなくレシーバーオブジェクトに対しての拡張関数として実装する
 *
 */
fun runExample() {
  val oddNumbers = mutableListOf<Int>().run {
    for (i in 1..10) {
      if (i % 2 == 1) this.add(i)
    }
    this.joinToString(separator = " ")
  }

  println(oddNumbers)
}

/**
 * Scope functions
 * スコープ関数
 *
 * let：Nullableなオブジェクトに名前をつけて処理する
 * runの処理を書き換えることができる
 * JavaのStreamでの書き方と同じ
 *
 */
fun letExample() {
  val oddNumbers = mutableListOf<Int>().let { list ->
    for (i in 1..10) {
      if (i % 2 == 1) list.add(i)
    }
    list.joinToString(separator = " ")
  }

  println(oddNumbers)
}

data class User10(val name: String)

/**
 * よく使うのはNullableのオブジェクトに対して処理する
 *
 * @param name 名前
 * @return User10のインスタンス
 */
fun createUser(name: String?): User10? {
  // itという暗黙の名前でレシーバーを扱うこともできる
  return name?.let { User10(it) }
//  return name?.let { userName -> User10(userName) }
}

/**
 * Scope functions
 * スコープ関数
 *
 * apply：レシーバーオブジェクトそのものを戻り値として返す
 * 取得したオブジェクトになにか処理や更新をした上でそのオブジェクトを返すような処理ができる
 *
 */
fun applyExample() {
  val oddNumbers = mutableListOf<Int>().apply {
    for (i in 1..10) {
      if (i % 2 == 1) this.add(i)
    }
    this.joinToString(separator = " ")
  }

  // applyがオブジェクトを返す
  // [1, 3, 5, 7, 9]
  println(oddNumbers)
}


data class User11(val id: Int, var name: String, var address: String)

fun getUser(id: Int): User11 {
  val user = User11(id, "Test11", "Chiba")
  println(user) // User11(id=100, name="Test11", address="Chiba")
  return user
}

fun updateUser(id: Int, newName: String, newAddress: String) {
  val user = getUser(id).apply {
    this.name = newName
    this.address = newAddress
  }
  println(user)
}

/**
 * Scope functions
 * スコープ関数
 *
 * also：オブジェクトに変更を加えて返す
 * applyと違いレシーバーオブジェクトであるUser11のインスタンスに名前をつけて処理する
 * Javaでおなじみ
 * 名前をつけずitという暗黙の名前も使える
 *
 * @param id ID
 * @param newName 更新後の名前
 * @param newAddress 更新後の住所
 */
fun updateUserAlso(id: Int, newName: String, newAddress: String) {
  val user = getUser(id).also { u ->
    u.name = newName
    u.address = newAddress
  }
  println(user)
}

/**
 * Operator overloading
 *
 * 演算子オーバーロードという機能で演算子を使用した際の処理を実装できる
 * 下記の演算子に対応する名前で関数を作る
 * +：plus
 * -：minus
 * *：times
 * /：div
 *
 * 四則演算に限らず比較演算子でも同様のオーバーロードができる
 *
 * @property value
 */
data class Num(val value: Int) {
  /**
   * +を使用した際の処理
   */
  operator fun plus(num: Num): Num {
    return Num(value + num.value)
  }

  /**
   * <>を使用した処理
   */
  operator fun compareTo(num: Num): Int {
    return value.compareTo(num.value)
  }
}

fun operatorExample() {
  val num = Num(5) + Num(1)
  println(num)

  val greaterThan = Num(5) > Num(1)
  val lessThan = Num(5) < Num(1)
  println(greaterThan)
  println(lessThan)
}

fun main() {
  listExample()
}

fun ifExample(num: Int) {
  if (num == 100) {
    println("num is 100.")
  }
}

fun whenExample(num: Int) {
  when (num) {
    100 -> println("Equal to 100")
    200 -> println("Equal to 200")
    else -> println("undefined value")
  }
}

fun whileExample() {
  var i = 1
  while (i < 10) {
    println("i is $i")
    i++
  }
}

fun forExample() {
  for (i in 1..10) {
    println("i is $i")
  }

  for (j in 1 until 10 step 2) {
    println("j is $j")
  }

  val list = listOf(1, 2, 5, 6, 10)
  for (k in list) {
    println("k is $k")
  }
}

/**
 * Class
 */
class Human {
  fun showName(name: String) {
    println(name)
  }
}

fun humanExample() {
  val human = Human()
  human.showName("Kotlin Learner")
}

/**
 * Inheritance
 *
 * KotlinはJavaと違いデフォルトのclassでは継承ができない。
 *
 * <code>open<code>修飾子を使うと修飾子をつけたclassを継承できるようになる。
 *
 * @property name 動物の名前
 */
open class Animal(val name: String) {
  fun showName() {
    println("name is $name")
  }

  open fun cries() {
    println("")
  }
}

class Dog(name: String): Animal(name) {
  override fun cries() {
    println("ワンワン")
  }
}

/**
 * Sealed Classes
 *
 * 継承する対象が制限されたclass。
 * シールドクラスは他ファイルから継承ができない。(=同一ファイル内であれば継承可能)
 *
 */
sealed class Platform {
  abstract fun showName()
}

class AndroidPlatform: Platform() {
  override fun showName() {
    println("Android.")
  }
}

class IosPlatform: Platform() {
  override fun showName() {
    println("iOS.")
  }
}

/**
 * Interfaces
 */
interface Greeter {
  fun hello()
}

class GreeterImpl: Greeter {
  override fun hello() {
    println("Hello, GreeterImpl")
  }
}

/**
 * Collections.List
 *
 * listOfは型推論が効くので型引数<code><><code>を省略できる
 * List型はRead Only(イミュータブル)なので後から要素を追加、削除ができない
 * 上記のような操作を行う場合にはMutableList型でListを作成する
 * 作成にはmutableListOfを使う
 *
 */
fun listExample() {
  val intList: List<Int> = listOf(1, 2, 3)
  println(intList)
  println(intList[1])

  val stringList: List<String> = listOf("one", "two", "three")
  println(stringList)
  println(stringList[1])

  val mutableList: MutableList<Int>  = mutableListOf(1, 2, 3)
  mutableList.add(4)
  println(mutableList)
}

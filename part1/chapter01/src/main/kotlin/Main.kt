fun main() {
  val dog = Dog("イヌ")
  dog.showName()
  dog.cries()
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
 * 継承
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
 * シールドクラス
 *
 * 継承する対象が制限されたclass。
 * シールドクラスは他ファイルから継承ができない。(=同一ファイル内であれば継承可能)
 *
 */
sealed class Platform {

}

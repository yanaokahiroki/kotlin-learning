fun main() {
  printOddOrEvenNumberText(3)
  printNumText(100)
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

package subtask5

class HighestPalindrome {
  fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
    val dev = false

    assert(n == digitString.length)
    assert(n / 2 == (n / 2) * 2)
    var a = ""
    var b = ""
    for (i in 0..(digitString.length / 2 - 1)) {
      a += digitString[i]
      b += digitString[digitString.lastIndex - i]
    }
    assert(a.length == b.length)

    val change = (0..a.lastIndex).map{ a[it] != b[it] }
    val notEdualDigits = change.filter{ it }.size

    if (k < notEdualDigits) return "-1"

    val halfRes = ArrayList((0..a.lastIndex).map { if (a[it] > b[it]) a[it] else b[it] })
    var turns = k - notEdualDigits

    for (i in 0..halfRes.lastIndex) {
      if (turns == 0) break
      if (change[i]) {
        if (halfRes[i] == '9') continue
        else { halfRes[i] = '9'; turns-- }
      } else {
        if (turns > 1) {
          if (halfRes[i] == '9') continue
          else { halfRes[i] = '9'; turns -=2 }
        } else {
          continue
        }
      }
    }

    if (dev) {
      println("a: ${a.toList()}, b: ${b.toList()}")
      println("notEdualDigits $notEdualDigits")
      println("halfRes $halfRes")
    }

    return (halfRes + halfRes.reversed()).joinToString("")
  }
}     

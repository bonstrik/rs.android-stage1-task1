package subtask5

class HighestPalindrome {
}


fun HighestPalindrome.highestValuePalindrome(n: Int, k: Int, digitString: String): String {
  fun isPol(str: String): Boolean {
    for (i in 0..(str.length / 2 - 1))
      if (str[i] != str[str.lastIndex - i]) 
        return false
    return true
  }

  class Oper(val numb: Int, val d: Int) {
  }
  val o = ArrayList<Oper>()
  for (i in 0..n-1)
    for (j in 0..9)
      o.add(Oper(i, j))

  val existPols = ArrayList<String>()
  
  val counter = IntArray(k)
  fun turn(i: Int): Boolean {
    if (counter[i] < o.lastIndex) {
      counter[i]++
      for (j in i+1..k-1) counter[j] = counter[i] + j - i
      return true
    } else {
      if (i == 0) 
        return false
      else
        return turn(i - 1)
    }
  }
  fun NextCounter(): Boolean {
    return turn(k - 1)
  }

  do {
    val curOs = ArrayList<Oper>()
    for (counterInd in counter.indices)
      curOs.add(o[counter[counterInd]])      
    var str = ""
    for (op in curOs.sortedBy{ it.numb }) 
      str += op.d.toChar()
    if (isPol(str)) existPols.add(str)
  } while (NextCounter())


  return if (existPols.size == 0) "-1" else existPols.max()!!
}

fun main() {
  val pal = HighestPalindrome()

  println(pal.highestValuePalindrome(4, 2, "1131"))


}

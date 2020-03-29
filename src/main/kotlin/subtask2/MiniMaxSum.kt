package subtask2

class MiniMaxSum {
  fun getResult(input: IntArray): IntArray {
    val a = ArrayList<Int>()

    for (v in input) 
      a.add(input.filter { it != v }.sum())
    val res = IntArray(2)
    res[0] = a.min()!!
    res[1] = a.max()!!
    println(res.joinToString("  "))
    return res
  }
}

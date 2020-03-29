package subtask3

class BillCounter {
  fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
    val needB = (bill.sum() - bill[k]) / 2.0
    var res: String
    if (needB == b.toDouble()) 
      res = "Bon Appetit"
    else
      res = "${b - needB}"
    println(res)
    return res
  }
}

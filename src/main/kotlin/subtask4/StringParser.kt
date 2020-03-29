package subtask4

class StringParser {
  fun getResult(inputString: String): Array<String> {

    val openChar  = arrayOf('[', '(', '<')
    val closeChar = arrayOf(']', ')', '>')
    var res = ArrayList<String>()

    fun addToRes(i: Int, j: Int) {
      var str = ""
      var delta = 0
      for (ind in (j + 1)..inputString.lastIndex) {
        when {
          (inputString[ind] == openChar[i]) -> delta--
          (inputString[ind] == closeChar[i] && delta != 0) -> delta++
          (inputString[ind] == closeChar[i] && delta == 0) -> {
            res.add(str)
            return
          }
        }
        str += inputString[ind]
      }  
    }

    for (j in inputString.indices) {
      val i = openChar.indexOf(inputString[j])
      if (i != -1) addToRes(i, j)
    }
    return Array<String>(res.size) { i -> res[i] }
  }
}

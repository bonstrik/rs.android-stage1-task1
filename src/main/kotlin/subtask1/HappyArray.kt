package subtask1

class HappyArray {
    fun convertToHappy(a: IntArray): IntArray {
        for (i in 1..(a.lastIndex-1))
            if (a[i] > a[i-1] + a[i+1])
                return convertToHappy(exclude(a, i))
        return a
    }
    fun exclude(a: IntArray, excl: Int): IntArray {
        var res = IntArray(a.size-1)
        var j = 0
        for (i in a.indices) 
            if (i != excl) { res[j] = a[i]; j++ }
        return res
    }
}

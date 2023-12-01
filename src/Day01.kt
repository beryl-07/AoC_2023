fun main() {
    fun part2(input: List<String>): Int {
        return input.size
    }
    fun part1(input: List<String>): Int {
        return input.size
    }
    /*
     Puzzle 01
      var count = 0
      input.forEach { el ->
          var str = ""
          el.forEach {
              if(it.isDigit())
                  str += it
          }
          count += (str[0]+str[(str.length-1)].toString()).toInt()
      }
      print(count)
    */

    val input = readInput("Day01_test/input0")

   /* Puzzle 01 . Refactor */
    var count = 0
    input.forEach { el ->
        val str = el.filter { it.isDigit() }
        count += (str[0] + str.last().toString()).toInt()
    }
    print(count)
}

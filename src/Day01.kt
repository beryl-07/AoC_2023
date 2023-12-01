import java.util.regex.Pattern

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
      print(count)  // 54597
    */

    val input = readInput("Day01_test/input0")

   /* Puzzle 01 . Refactor */
    var count = 0
    // input.forEach { el ->
    //     val str = el.filter { it.isDigit() }
    //     count += (str[0] + str.last().toString()).toInt()
    // }
    
    /* Puzzle 02 */
    val digitMap = mapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4,
            "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)

    val regex = "(?=(\\d|one|two|three|four|five|six|seven|eight|nine))"

    input.forEach {
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(it)
        var str = ""
        while (matcher.find()) {
            for (i in 1..matcher.groupCount()) {
                str += digitMap[matcher.group(i)]?:matcher.group(i)
            }
        }
        count += (str[0] + str.last().toString()).toInt()
    }
    println(count)
}

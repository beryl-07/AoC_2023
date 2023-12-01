fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day01_test/input0")

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
}
